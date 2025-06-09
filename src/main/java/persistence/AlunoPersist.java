//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package persistence;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import business.*;
import business.*;

public class AgendaPersist {
    public AgendaPersist() {
    }

    public void salvar(Agenda var1) {
        if (var1 != null && var1.getContatos() != null) {
            BufferedWriter var2 = null;

            try {
                var2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("agenda.txt"), StandardCharsets.UTF_8));

                for(Contato var4 : var1.getContatos()) {
                    String var10001 = var4.getNome();
                    ((Writer)var2).write(var10001 + "," + var4.getTelefone() + "\n");
                }
            } catch (IOException var13) {
                System.out.println("Erro ao salvar agenda: " + var13.getMessage());
                var13.printStackTrace();
            } finally {
                if (var2 != null) {
                    try {
                        ((Writer)var2).close();
                    } catch (IOException var12) {
                        System.out.println("Erro ao fechar o writer: " + var12.getMessage());
                        var12.printStackTrace();
                    }
                }

            }

        } else {
            System.out.println("Agenda ou lista de contatos está nula.");
        }
    }
}
