public class ConversionDeMonedas {
    private final ConexionConApi conexionConApi;

    public ConversionDeMonedas() {
        this.conexionConApi = new ConexionConApi();
    }

    public String convertirMoneda(int option, double monedaEntradaUsuario) {
        String monedaDeOrigen = "";
        String aMonedaConevertida = "";
        String nombreDeMoneda = "";

        switch (option) {
            case 1:
                monedaDeOrigen = "USD";
                aMonedaConevertida = "ARS";
                nombreDeMoneda = "pesos Argentinos";
                break;
            case 2:
                monedaDeOrigen = "ARS";
                aMonedaConevertida = "USD";
                nombreDeMoneda = "dólares";
                break;
            case 3:
                monedaDeOrigen = "USD";
                aMonedaConevertida = "BRL";
                nombreDeMoneda = "reales brasileños";
                break;
            case 4:
                monedaDeOrigen = "BRL";
                aMonedaConevertida = "USD";
                nombreDeMoneda = "dólares";
                break;
            case 5:
                monedaDeOrigen = "USD";
                aMonedaConevertida = "COP";
                nombreDeMoneda = "pesos Colombianos";
                break;
            case 6:
                monedaDeOrigen = "COP";
                aMonedaConevertida = "USD";
                nombreDeMoneda = "dólares";
                break;
        }
        double rate = conexionConApi.convertirTipoDeMoneda(monedaDeOrigen, aMonedaConevertida);
        double monedaProcesada = monedaEntradaUsuario * rate;
        return String.format("El valor de %.2f %s corresponde a %.2f %s", monedaEntradaUsuario, monedaDeOrigen, monedaProcesada, nombreDeMoneda);
    }
}
