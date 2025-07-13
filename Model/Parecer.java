package Model;

public class Parecer {
    private int id;
    private int requerimento_id;
    private String texto;
    private String data_parecer;
    public Parecer(int id, int requerimento_id, String texto, String data_parecer) {
        this.id = id;
        this.requerimento_id = requerimento_id;
        this.texto = texto;
        this.data_parecer = data_parecer;
    }

    public int id() {
        return id;
    }
    public String data_parecer() {
        return data_parecer;
    }
}
