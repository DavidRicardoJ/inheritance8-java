package entities;

public class Individual extends TaxPayer {
    private Double healthExpenditures;

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public double tax() {
        double tax = 0.0;
        if (super.getAnualIncome() < 20000.0) {
            tax = getAnualIncome() * 0.15 - healthExpenditures *0.5;
        } else {
            tax = getAnualIncome() * 0.25 - healthExpenditures *0.5;
        }
        return tax;
    }

    @Override
    public String toString() {
        return getName() + ": $ " + String.format("%.2f", tax());
    }
}
