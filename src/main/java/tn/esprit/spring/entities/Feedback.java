package tn.esprit.spring.entities;

import com.sun.istack.NotNull;

public class Feedback {
	@NotNull
    private String name;

    @NotNull
    //@Email
    private String email;

    @NotNull
  //  @Min(10)
    private String feedback;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Feedback() {
		
	}
    
    
    
    
    
    
}
