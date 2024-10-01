public class Formato {
    private String monedaBase;
    private String monedaFinal;
    private double indiceDeConversion;
    private double valorTotal;

    public Formato(Intercambio cambioDeMoneda){
        this.monedaBase = cambioDeMoneda.base_code();
        this.monedaFinal = cambioDeMoneda.target_code();
        this.indiceDeConversion = cambioDeMoneda.conversion_rate();
        this.valorTotal = cambioDeMoneda.conversion_result();
    }
    @Override
    public String toString() {
        return
                ", moneda base='" + monedaBase + '\'' +
                ", moneda final='" + monedaFinal + '\'' +
                ", indice de conversión= " + indiceDeConversion +
                ", valor total= " + valorTotal;
    }
}
