import java.io.*;
import java.net.*;
import java.util.Scanner;

public class NetworkMatch {

    private Team local;

    public NetworkMatch(Team newTeam) {
        local = newTeam;
    }

    public void host(int port) { //Hospeda comunicando-se por meio da porta fornecida.
        try (
            ServerSocket serverSocket = new ServerSocket(port);
            Socket client = serverSocket.accept();
            ObjectOutputStream out = new ObjectOutputStream( client.getOutputStream() );
            ObjectInputStream in = new ObjectInputStream( client.getInputStream() );
        ){
            //Imprime mensagem para mostrar que a conexão ocorreu com sucesso.
            out.writeObject("Servidor: Conectado com sucesso!");
            System.out.println("Conectado.");

            //Recebe o time oponente do cliente.
            Team remote = (Team)(in.readObject());
            System.out.println("Recebida informação sobre time oponente.");

            //Realiza a batalha entre ambos os times, enviando os resultados para as saídas do servidor e cliente.
            String battleOutput = local.resolveBattle(remote);
            System.out.println( battleOutput );

            //Envia os eventos.
            out.writeObject( battleOutput );
            //Devolve o time oponente ao cliente, modificado.
            out.writeObject( local );
            System.out.println("Devolvendo informação sobre time oponente.");
        } catch (IOException e) {
            System.err.println("Erro ao ler dados da porta: " + port + "\n" + e.getMessage() );
        } catch (ClassNotFoundException e) {
            System.err.println("Erro: " + e.getMessage());
        } catch(Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }
    }

    public void connect(String hostname, int port) { //Connecta-se a um servidor para batalha.
        try (
            Socket socket = new Socket(hostname, port);
            ObjectOutputStream out = new ObjectOutputStream( socket.getOutputStream() );
            ObjectInputStream in = new ObjectInputStream( socket.getInputStream() );
        ){
            //Lê as mensagens de conexão do servidor.
            System.out.println( (String)( in.readObject() ) );

            //Envia o objeto Team local para o servidor.
            out.writeObject( local );
            System.out.println("Dados enviados.");

            //Lê os resultados da batalha e exibe ao cliente.
            System.out.print( (String)in.readObject() );
            //Recebe o objeto Team modificado pelo servidor.
            local = (Team) (in.readObject());
            System.out.println("Saída recebida");
        } catch (UnknownHostException e) {
            System.err.println("Host não identificado: " + hostname);
        } catch (IOException e) {
            System.err.println("Não foi possível adquirir uma entrada/saída a " + hostname + "\nMensagem: " + e.getMessage());
        } catch(Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }
    }

}
