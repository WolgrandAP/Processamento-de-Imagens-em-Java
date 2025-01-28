package demonstracao;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Demonstracao {
    public static void main(String[] args) {
        try {
            File arquivoEntrada = new File("C:\\Users\\Wolgrand\\Desktop\\imagem.jpg");
            BufferedImage imagem = ImageIO.read(arquivoEntrada);

            int largura = imagem.getWidth();
            int altura = imagem.getHeight();

            for (int y = 0; y < altura; y++) {
                for (int x = 0; x < largura; x++) {
                    Color cor = new Color(imagem.getRGB(x, y));

                    int r = cor.getRed();
                    int g = cor.getGreen();
                    int b = cor.getBlue();

                    int luminancia = (int)(0.2989 * r + 0.5870 * g + 0.1140 * b);

                    Color corCinza = new Color(luminancia, luminancia, luminancia);

                    imagem.setRGB(x, y, corCinza.getRGB());
                }
            }

            File arquivoSaida = new File("C:\\Users\\Wolgrand\\Desktop\\cinza.jpg");
            ImageIO.write(imagem, "jpg", arquivoSaida);
            System.out.println("Conversão da imagem concluida");

        } catch (IOException erro) {
            erro.printStackTrace();
        }
    }
}
