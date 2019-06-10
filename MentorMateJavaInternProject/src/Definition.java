
public class Definition {

	    private int topPerformersThreshold;
	    private boolean useExperienceMultiplier;
	    private int periodLimit;

	    public Definition(int topPerformersThreshold, boolean useExperienceMultiplier, int periodLimit){
	        this.topPerformersThreshold = topPerformersThreshold;
	        this.useExperienceMultiplier = useExperienceMultiplier;
	        this.periodLimit = periodLimit;
	    }
	    public int getPeriodLimit() {
	        return periodLimit;
	    }

	    public void setPeriodLimit(int periodLimit) {
	        this.periodLimit = periodLimit;
	    }

	    public boolean isUseExperienceMultiplier() {
	        return useExperienceMultiplier;
	    }

	    public void setUseExperienceMultiplier(boolean useExperienceMultiplier) {
	        this.useExperienceMultiplier = useExperienceMultiplier;
	    }

	    public int getTopPerformersThreshold() {
	        return topPerformersThreshold;
	    }

	    public void setTopPerformersThreshold(int topPerformersThreshold) {
	        this.topPerformersThreshold = topPerformersThreshold;
	    }
}
