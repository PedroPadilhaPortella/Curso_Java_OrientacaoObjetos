package entities;

public class USAInterestService implements InterestService {
    private Double interestRate;

    public USAInterestService(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public double getInterestRate() {
        return this.interestRate;
    }
}