package booking;

public class PriceDetails {
    private double mietpreis;
    private double steuern;
    private double gebuehren;
    private double anzahlung;

    private PriceDetails(Builder builder) {
        this.mietpreis = builder.mietpreis;
        this.steuern = builder.steuern;
        this.gebuehren = builder.gebuehren;
        this.anzahlung = builder.anzahlung;
    }

    public static class Builder {
        private double mietpreis;
        private double steuern;
        private double gebuehren;
        private double anzahlung;

        public Builder setMietpreis(double mietpreis) {
            this.mietpreis = mietpreis;
            return this;
        }

        public Builder setSteuern(double steuern) {
            this.steuern = steuern;
            return this;
        }

        public Builder setGebuehren(double gebuehren) {
            this.gebuehren = gebuehren;
            return this;
        }

        public Builder setAnzahlung(double anzahlung) {
            this.anzahlung = anzahlung;
            return this;
        }

        public PriceDetails build() {
            return new PriceDetails(this);
        }
    }

    public double berechneGesamtpreis() {
        return mietpreis + steuern + gebuehren;
    }
}
