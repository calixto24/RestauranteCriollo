package utp.restaurant.model;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javax.imageio.ImageIO;
import utp.restaurant.service.CustomerService;
import utp.restaurant.service.model.SunatCustomer;

public class Bill extends Voucher<Long, JuridicalCustomer> {

    private long id_Bill;
    private JuridicalCustomer customer;

    public Bill(JuridicalCustomer customer, Order order, Employee cashier) {
        super(order, cashier);
        this.id_Bill = System.currentTimeMillis() + new Random().nextInt(1000);
        this.customer = customer;
    }

    public Bill() {
        this.id_Bill = System.currentTimeMillis() + new Random().nextInt(1000);
    }

    /**
     * METODOS ABSTRACTOS*
     */
    @Override
    public JuridicalCustomer getCustomerData(Long ruc) throws Exception {
        customer = new JuridicalCustomer();
        System.out.println("metodo get Customer");
        SunatCustomer sc = CustomerService.getCustomer(ruc);
        
        customer.setRuc(Long.parseLong(sc.getNumeroDocumento()));
        customer.setSocialReason(sc.getRazonSocial());
        customer.setAddress(sc.getDireccion());
        
        return customer;
    }

    @Override
    public void generateTicket(JuridicalCustomer jp) throws Exception {
        
        float margin = 10;
        Rectangle ticketSize = new Rectangle(227, 800);
        Document document = new Document(ticketSize, margin, margin, margin, margin);
        
        PdfWriter.getInstance(document, new FileOutputStream("uploads/bills/bill_" + id_Bill + ".pdf"));
        document.open();
        
        document.add(p("Anticuchos del Peru S.A.C", Element.ALIGN_CENTER));
        document.add(p("Avenida Primavera 557 San Borja", Element.ALIGN_CENTER));
        document.add(p("\n"));
        document.add(p("RUC: 20514680401", Element.ALIGN_CENTER));
        document.add(p("Telef: (01) 2425957", Element.ALIGN_CENTER));

        document.add(p("-".repeat(34)));
        
        document.add(p("Razon Social: " + jp.getSocialReason()));
        document.add(p("RUC: " + jp.getRuc()));
        document.add(p("Dirección: " + jp.getAddress()));
        
        document.add(p("-".repeat(34)));
        
        document.add(p("FACTURA DE VENTA ELECTRONICA", Element.ALIGN_CENTER));
        document.add(p("BA-" + id_Bill, Element.ALIGN_CENTER));
        
        document.add(p("-".repeat(34)));
        
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter tf = DateTimeFormatter.ofPattern("hh:mm:ss");
        
        document.add(p("Fecha: " + df.format(date)));
        document.add(p("Hora: " + tf.format(time)));

        document.add(p("-".repeat(34)));

        document.add(p(String.format("%-15s Cant P.unit Precio", "Producto")));
        for (ItemOrder io : order.getItemOrderList()) {
            document.add(p(String.format("%-15s %4d %6.2f %6.2f", io.getItemMenu().getName(), io.getAmount(), io.getItemMenu().getPrice(), io.getTotal())));
        }

        document.add(p("-".repeat(34)));
        
        document.add(p(String.format("SUB TOTAL: %23s", formatPrice(order.getTotal_Price()))));
        document.add(p(String.format("OP. GRAVADAS: %20s", formatPrice(taxed))));
        document.add(p(String.format("IGV: %29s", formatPrice(igv))));
        document.add(p(String.format("DESC. TOTAL: %21s", formatPrice(discount))));
        document.add(p(String.format("PAGO ADICIONAL: %18s", formatPrice(additionalPayments))));
        document.add(p("\n"));
        document.add(p(String.format("TOTAL: %27s", formatPrice(totalPrice))));
        
        document.add(p("-".repeat(34)));
        
        document.add(p("Cajero: " + cashier.getName() + " " + cashier.getLastname_paternal()));

        document.add(p("-".repeat(34)));
        
//        document.add(p(String.format("EFECTIVO: %24s", formatPrice(paymentReceived))));
//        document.add(p(String.format("VUELTO: %26s", formatPrice(turned))));
//        document.add(p("-".repeat(34)));
        
        Image qrImage = Image.getInstance(generateQrCode());
        qrImage.setAlignment(Element.ALIGN_CENTER);
        document.add(qrImage);
        
        document.add(p("-".repeat(34)));

        document.add(p("GRACIAS POR SU COMPRA", Element.ALIGN_CENTER));
        
        document.add(p("-".repeat(34)));

        document.close();

    }
    
    public byte[] generateQrCode() throws Exception {
        
        //Se establece el contenido del QR
        String qrData = customer.getRuc() + "|" + date.toString();
        
        //Dicho objeto sera util para establecer la estrcutura del QR
        QRCodeWriter qRCodeWriter = new QRCodeWriter();

        //Con el metodo encode creamos la estrcutura
        BitMatrix bitMatrix = qRCodeWriter.encode(qrData, BarcodeFormat.QR_CODE, 150, 150);

        //convierte la matriz de bits a una imagen
        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

        //objeto para almacenar los bits de la imagen
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        //escribe la imagen en formato PNG en el ByteArrayOutputStream
        ImageIO.write(bufferedImage, "png", baos);

        baos.flush();

        //convertimos el el baos en un array de byte
        byte[] qrImageData = baos.toByteArray();

        baos.close();

        return qrImageData;
    }
    
    private Paragraph p(String txt) {
        Font font = new Font(Font.FontFamily.COURIER, 10);

        return new Paragraph(txt, font);
    }
    
    private Paragraph p(String txt, int alignmet) {
        Font font = new Font(Font.FontFamily.COURIER, 10);
        Paragraph paragraph = new Paragraph(txt, font);
        paragraph.setAlignment(alignmet);
        
        return paragraph;
    }
    
    private String formatPrice(double price) {
        return String.format("S/. %,.2f", price);
    }

    public long getId_Bill() {
        return id_Bill;
    }

    public void setId_Bill(long id_Bill) {
        this.id_Bill = id_Bill;
    }

    public JuridicalCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(JuridicalCustomer customer) {
        this.customer = customer;
    }
}
