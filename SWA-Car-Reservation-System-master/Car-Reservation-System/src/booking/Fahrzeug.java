package booking;

public class Fahrzeug {
	  private String kategorie;
	    private String modell;
	    private boolean automatik;
	    private boolean klimaanlage;
	    private boolean navigationssystem;

	    private Fahrzeug(Builder builder) {
	        this.kategorie = builder.kategorie;
	        this.modell = builder.modell;
	        this.automatik = builder.automatik;
	        this.klimaanlage = builder.klimaanlage;
	        this.navigationssystem = builder.navigationssystem;
	    }

	    public static class Builder {
	        private String kategorie;
	        private String modell;
	        private boolean automatik;
	        private boolean klimaanlage;
	        private boolean navigationssystem;

	        public Builder setKategorie(String kategorie) {
	            this.kategorie = kategorie;
	            return this;
	        }

	        public Builder setModell(String modell) {
	            this.modell = modell;
	            return this;
	        }

	        public Builder setAutomatik(boolean automatik) {
	            this.automatik = automatik;
	            return this;
	        }

	        public Builder setKlimaanlage(boolean klimaanlage) {
	            this.klimaanlage = klimaanlage;
	            return this;
	        }

	        public Builder setNavigationssystem(boolean navigationssystem) {
	            this.navigationssystem = navigationssystem;
	            return this;
	        }

	        public Fahrzeug build() {
	            return new Fahrzeug(this);
	        }
	    }

	    // Getter-Methoden
	    public String getKategorie() { return kategorie; }
	    public String getModell() { return modell; }
	    public boolean isAutomatik() { return automatik; }
	    public boolean isKlimaanlage() { return klimaanlage; }
	    public boolean isNavigationssystem() { return navigationssystem; }
}
