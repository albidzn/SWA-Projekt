package booking;

public class InsuranceDetails {
    private boolean vollkasko;
    private double selbstbeteiligung;
    private boolean haftpflicht;
    private boolean diebstahlschutz;

    private InsuranceDetails(Builder builder) {
        this.vollkasko = builder.vollkasko;
        this.selbstbeteiligung = builder.selbstbeteiligung;
        this.haftpflicht = builder.haftpflicht;
        this.diebstahlschutz = builder.diebstahlschutz;
    }

    public static class Builder {
        private boolean vollkasko;
        private double selbstbeteiligung;
        private boolean haftpflicht;
        private boolean diebstahlschutz;

        public Builder setVollkasko(boolean vollkasko) {
            this.vollkasko = vollkasko;
            return this;
        }

        public Builder setSelbstbeteiligung(double selbstbeteiligung) {
            this.selbstbeteiligung = selbstbeteiligung;
            return this;
        }

        public Builder setHaftpflicht(boolean haftpflicht) {
            this.haftpflicht = haftpflicht;
            return this;
        }

        public Builder setDiebstahlschutz(boolean diebstahlschutz) {
            this.diebstahlschutz = diebstahlschutz;
            return this;
        }

        public InsuranceDetails build() {
            return new InsuranceDetails(this);
        }
    }
}
