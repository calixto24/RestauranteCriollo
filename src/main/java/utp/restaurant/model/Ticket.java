package utp.restaurant.model;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import java.io.FileOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javax.imageio.ImageIO;
import utp.restaurant.service.CustomerService;
import utp.restaurant.service.model.ReniecCustomer;

public class Ticket extends Voucher<Integer, NaturalCustomer> {

    private long id_Ticket;
    private NaturalCustomer customer;

    public Ticket(NaturalCustomer customer, Order order, Employee cashier) {
        super(order, cashier);
        this.customer = customer;
    }

    public Ticket() {
    }

    /**
     * METODOS ABSTRACTOS*
     */
    @Override
    public NaturalCustomer getCustomerData(Integer dni) throws Exception {
        customer = new NaturalCustomer();
        System.out.println("metodo get Customer");
        ReniecCustomer rc = CustomerService.getCustomer(dni);
        
        customer.setDni(dni);
        customer.setName(rc.getNombres());
        customer.setLastname_maternal(rc.getApellidoMaterno());
        customer.setLastname_paternal(rc.getApellidoPaterno());
        
        return customer;
    }

    @Override
    public void generateTicket(NaturalCustomer nc) throws Exception {
        float maring = 10;
        Rectangle ticketSize = new Rectangle(227, 800);
        Document document = new Document(ticketSize, maring, maring, maring, maring);

        PdfWriter.getInstance(document, new FileOutputStream("uploads/tickets/ticket_" + id_Ticket + ".pdf"));
        document.open();
        
        document.add(p("Anticuchos del Peru S.A.C", Element.ALIGN_CENTER));
        document.add(p("Avenida Primavera 557 San Borja", Element.ALIGN_CENTER));
        document.add(p("\n"));
        document.add(p("RUC: 20514680401", Element.ALIGN_CENTER));
        document.add(p("Telef: (01) 2425957", Element.ALIGN_CENTER));

        document.add(p("-".repeat(34)));

        document.add(p("Cliente: " + nc.getName() + " " + nc.getLastname_paternal()));
        document.add(p("DNI: " + nc.getDni()));
        
        document.add(p("-".repeat(34)));
        
        document.add(p("BOLETA DE VENTA ELECTRONICA", Element.ALIGN_CENTER));
        document.add(p("BA-" + id_Ticket, Element.ALIGN_CENTER));
        
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
        String qrData = customer.getDni() + "|" + date.toString();
        QRCodeWriter qRCodeWriter = new QRCodeWriter();

        BitMatrix bitMatrix = qRCodeWriter.encode(qrData, BarcodeFormat.QR_CODE, 150, 150);

        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        ImageIO.write(bufferedImage, "png", baos);

        baos.flush();

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

    public long getId_Ticket() {
        return id_Ticket;
    }

    public void setId_Ticket(long id_Ticket) {
        this.id_Ticket = id_Ticket;
    }

    public NaturalCustomer getNaturalPerson() {
        return customer;
    }

    public void setNaturalPerson(NaturalCustomer customer) {
        this.customer = customer;
    }
}
