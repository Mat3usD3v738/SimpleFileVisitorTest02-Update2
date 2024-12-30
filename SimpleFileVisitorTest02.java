package ZB_NIO;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SimpleFileVisitorTest02 {
    public static void main(String[] args) throws IOException {
        System.out.flush();
        Locale locale = Locale.getDefault() ;
        ResourceBundle rb = ResourceBundle.getBundle("mensagens",locale);
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("");
            System.out.println("\033[0;32m=========="+rb.getString("Programa_Inicializado")+"===========\033[0m");
            System.out.println("");
            Path root = null;
            System.out.println("\033[0;32m-> "+rb.getString("Digite_o_caminho")+"\033[0m");
            String caminho = in.nextLine();
            root = Paths.get(caminho);
            System.out.println("\033[0;32m-> "+rb.getString("Digite_a_extencao")+"\033[0m");
            List.extencao = new StringBuilder(in.nextLine());
            Files.walkFileTree(root, new List());
            System.out.println("\033[0;31m============================================================================================================\033[0m");


            System.out.println("\033[0;32m-> "+rb.getString("Arquivos_encontrados_com_extencao")+" [" + List.extencao + "] : " + List.na + "" +
                    "\033[0m");
            System.out.println("\033[0;32m-> "+List.tamanho / 100000 +" mb "+rb.getString("em_arquivos")+"\033[0m");
            System.out.println("");
            System.out.println("\033[0;32m=========="+rb.getString("Programa_Finalizado")+"==========\033[0m");

        } catch (InputMismatchException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class List extends SimpleFileVisitor<Path> {
    static StringBuilder extencao = null;
    static long na;
static long tamanho = 0l;
    Locale locale = Locale.getDefault();
    ResourceBundle rb = ResourceBundle.getBundle("mensagens",locale);
public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        StringBuilder EXTENCAO_DO_ARQUIVO = new StringBuilder(extencao);

        if (file.toString().endsWith(EXTENCAO_DO_ARQUIVO.toString())) {
            BasicFileAttributes bfa = Files.readAttributes(file, BasicFileAttributes.class);
            System.out.println("\033[0;31m============================================================================================================\033[0m");
            System.out.println("\033[0;34m"+rb.getString("Nome_do_arquivo")+ ": \033[0m" + "\033[0;32m" + file.toFile().getName() + "\033[0m");
            System.out.println("\033[0;34m"+rb.getString("Caminho_do_arquivo")+": \033[0m" + "\033[0;32m" + file.toFile().getAbsolutePath() + "\033[0m");
            na++;
            tamanho += bfa.size() ;
        }
        return FileVisitResult.CONTINUE;
    }
}
