import java.util.HashMap;

public class Cheque {

    private Double valor;

    @SuppressWarnings("serial")
    private HashMap<Integer, String> palavras = new HashMap<Integer, String>() {
        {
            put(1, "um");
            put(2, "dois");
            put(3, "tres");
            put(4, "quatro");
            put(5, "cinco");
            put(6, "seis");
            put(7, "sete");
            put(8, "oito");
            put(9, "nove");
            put(10, "dez");
            put(11, "onze");
            put(12, "doze");
            put(13, "treze");
            put(14, "quatorze");
            put(15, "quinze");
            put(16, "dezesseis");
            put(17, "dezessete");
            put(18, "dezoito");
            put(19, "dezenove");
            put(20, "vinte");
            put(30, "trinta");
            put(40, "quarenta");
            put(50, "cinquenta");
            put(60, "sessenta");
            put(70, "setenta");
            put(80, "oitenta");
            put(90, "noventa");
            put(100, "cento");
            put(200, "duzentos");
            put(300, "trezentos");
            put(400, "quatrocentos");
            put(500, "quinhentos");
            put(600, "seicentos");
            put(700, "setecentos");
            put(800, "oitocentos");
            put(900, "novecento");
        }
    };

    public Cheque(Double valor) {
        this.valor = valor;
    }

    public Cheque(Integer valor) {
        this.valor = valor.doubleValue();
    }

    private String humanizedDezena(Integer value) {
        return humanizedDezena(new Double(value));
    }
    
    private String humanizedDezena(Double value) {
        if (value <= 20 || (value % 10) == 0) { return palavras.get(value.intValue()); }

        Double parteUnidade = (value % 10);
        Double parteDezena  = value - parteUnidade;

        String humanizedDezena = palavras.get(parteDezena.intValue());
        String humanizedUnidade = palavras.get(parteUnidade.intValue());
        
        return humanizedDezena + " e " + humanizedUnidade;
    }

    private String humanizedCentena(Double value) {
        Double parteDezena  = value % 100;
        Double parteCentena = value - parteDezena;

        if (value == 100 && parteDezena == 0) { return "cem"; }

        return palavras.get(parteCentena.intValue()) + " e "
                + humanizedDezena(parteDezena);
    }

    private String humanizedCentena(Integer value) {
        return humanizedCentena(new Double(value));
    }
    
    private String convertToExtensive(Integer value) {
        int tamanho = value.toString().length();

        if (tamanho <= 2) { return humanizedDezena(value); }

        if (tamanho == 3) { return humanizedCentena(value); }

        if (tamanho >= 4) {
            int parteMilhar = Integer.valueOf(value / 1000);
            int parteCentena = Integer.valueOf(value % 1000);

            String humanizedMilhar = (parteMilhar != 1) ? (convertToExtensive(parteMilhar) + "mil")
                    : "mil";

            if (parteCentena > 0) { return humanizedMilhar + ", "
                    + humanizedCentena(parteCentena); }

            return humanizedMilhar;
        }

        return "";
    }

    public String humanize() {
        int parteInteira = this.valor.intValue();
        String reais = (parteInteira > 0) ? ((convertToExtensive(parteInteira) + ((parteInteira != 1) ? " reais"
                : " real")))
                : "";

        int parteFracionaria = (int) ((valor % 1) * 100);
        String cents = convertToExtensive(parteFracionaria) + " centavos";
        String centavos = (parteFracionaria > 0) ? ((parteInteira > 0) ? " e " : "") + cents : "";

        return reais + centavos;
    }
}
