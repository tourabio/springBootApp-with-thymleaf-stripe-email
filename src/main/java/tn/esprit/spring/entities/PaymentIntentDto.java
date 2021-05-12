package tn.esprit.spring.entities;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




public class PaymentIntentDto {
	public enum Currency{
        usd, eur,din;
    }
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	//@NotBlank
	private String description;
    private int amount;
    private Currency currency;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public PaymentIntentDto() {
		
	}
    
}