
public class Employee {
	
	    private String name;
	    private int totalSales;
	    private int salesPeriod;
	    private double experienceMultiplier;
	    private double score;


	    
	    public Employee(String name, int totalSales, int salesPeriod, double experienceMultiplier){
	        this.name = name;
	        this.totalSales = totalSales;
	        this.salesPeriod = salesPeriod;
	        this.experienceMultiplier = experienceMultiplier;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public double getScore() {
	        return score;
	    }

	    public void setScore(double score) {
	        this.score = score;
	    }

	    public double getExperienceMultiplier() {
	        return experienceMultiplier;
	    }

	    public void setExperienceMultiplier(double experienceMultiplier) {
	        this.experienceMultiplier = experienceMultiplier;
	    }

	    public int getSalesPeriod() {
	        return salesPeriod;
	    }

	    public void setSalesPeriod(int salesPeriod) {
	        this.salesPeriod = salesPeriod;
	    }

	    public int getTotalSales() {
	        return totalSales;
	    }

	    public void setTotalSales(int totalSales) {
	        this.totalSales = totalSales;
	    }


	   
	    public void calculateScore(Definition definition){
	        if (definition.isUseExperienceMultiplier()){
	            this.score = this.getTotalSales() / this.getSalesPeriod() * this.getExperienceMultiplier();
	            
	        }
	        else {
	            this.score = this.getTotalSales() / this.getSalesPeriod();
	            
	        }
	    }
		

}
