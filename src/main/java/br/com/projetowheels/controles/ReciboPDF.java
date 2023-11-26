package br.com.projetowheels.controles;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReciboPDF {
    private String bikeId;
    private String preco;
    private String qntDias;
    private String nomeCliente;
    private String codPostal;

    public ReciboPDF(String bikeId, String preco, String qntDias, String nomeCliente, String codPostal) {
        this.bikeId = bikeId;
        this.preco = preco;
        this.qntDias = qntDias;
        this.nomeCliente = nomeCliente;
        this.codPostal = codPostal;
    }

    public void gerarNotaFiscal(String nomeArquivo) {

        Document document = new Document(PageSize.A4, 50, 50, 50, 50);

        try {

            String diretorio = "arquivos";
            Path dir = Paths.get(diretorio);

            if (!Files.exists(dir)) {
                Files.createDirectory(dir);
            }

            PdfWriter.getInstance(document, new FileOutputStream(nomeArquivo));

            document.open();

            // Define a fonte e o tamanho para o título
            Font fonteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 23, BaseColor.BLACK);
            Font fontPadrao = FontFactory.getFont(FontFactory.HELVETICA, 13, BaseColor.BLACK);

            Paragraph titulo = new Paragraph("WHEELS", fonteTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);

            Paragraph subtitulo = new Paragraph("Estabelecimento de Aluguel", fontPadrao);
            subtitulo.setAlignment(Element.ALIGN_CENTER);

            Paragraph rua = new Paragraph("Rua São José 60, Centro Rio de Janeiro 00000000", fontPadrao);
            rua.setAlignment(Element.ALIGN_CENTER);

            Paragraph cnpj = new Paragraph("CNPJ: 00. 000. 000/0001-00", fontPadrao);
            cnpj.setAlignment(Element.ALIGN_CENTER);


            document.add(titulo);
            document.add(subtitulo);
            document.add(rua);
            document.add(cnpj);
            document.add(new Chunk(new LineSeparator()));
            document.add(Chunk.NEWLINE);

            Paragraph extrato = new Paragraph("Extrato 000000", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 15, BaseColor.BLACK));
            Paragraph SAT = new Paragraph("CUPOM FISCAL ELETRÔNICO - SAT", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 15, BaseColor.BLACK));
            extrato.setAlignment(Element.ALIGN_CENTER);
            SAT.setAlignment(Element.ALIGN_CENTER);

            document.add(extrato);
            document.add(SAT);
            document.add(new Chunk(new LineSeparator()));


            // Adiciona detalhes do cliente
            document.add(new Paragraph("Código Postal do Cliente: " + codPostal));
            document.add(new Paragraph("Nome do Cliente: " + nomeCliente));
            document.add(new Paragraph("Numero de Dias: " + qntDias));
            document.add(new Paragraph("Bike ID: " + bikeId));
            document.add(Chunk.NEWLINE);


            // Adiciona informações de pagamento
            document.add(Chunk.NEWLINE);
            document.add(new Paragraph("Total Bruto: R$" + preco));
            document.add(new Paragraph("Desconto: R$ 0"));
            document.add(new Paragraph("Troco: R$ 0"));
            document.add(new Paragraph("Total: R$ " + preco, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.BLACK)));
            document.add(new Chunk(new LineSeparator()));

            Paragraph dataCompra = new Paragraph("Data da Compra: " + formatarData(new Date()));
            dataCompra.setAlignment(Element.ALIGN_CENTER);
            document.add(dataCompra);

            // Adiciona um QR code ao PDF
            String qrCodeData = "https://exemplo.com";
            BarcodeQRCode qrCode = new BarcodeQRCode(qrCodeData, 250, 250, null);
            Image qrCodeImage = qrCode.getImage();
            qrCodeImage.setAbsolutePosition(170, 130);

            document.add(qrCodeImage);

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        document.close();
    }

    private String formatarData(Date data) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(data);
    }
}
