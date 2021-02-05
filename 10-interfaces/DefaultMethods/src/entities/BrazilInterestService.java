package entities;

public class BrazilInterestService implements InterestService {
    private Double interestRate;

    public BrazilInterestService(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public double getInterestRate() {
        return this.interestRate;
    }
}