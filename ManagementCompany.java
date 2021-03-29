
public class ManagementCompany {

	private int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private String taxID;
	private Property[] properties;
	private int MGMT_WIDTH;
	private int MGMT_DEPTH;
	private Plot plot;
	private int index = 0;

	//  No-Arg Constructor that creates a ManagementCompany object using empty strings and default Plot
	ManagementCompany() {
		name = "";
        taxID = "";
        plot = new Plot();
        properties = new Property[MAX_PROPERTY];
        index = 0;
	}
		
	//    Constructor Creates a ManagementCompany object using the passed information.
	ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(0,0,MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
		index = 0;
	}
	
	//Constructor Creates a ManagementCompany object using the passed information.
	ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(x,y,width, depth);
		this.properties = new Property[MAX_PROPERTY];
		index = 0;
	}
	
	//    Copy Constructor that creates a ManagementCompany object from another ManagementCompany object
	ManagementCompany(ManagementCompany otherCompany) {
		name = otherCompany.name;
		taxID = otherCompany.taxID;
		mgmFeePer = otherCompany.mgmFeePer;
		plot = otherCompany.plot;
		properties = new Property[MAX_PROPERTY];
	}
	
	//Return the MAX_PROPERTY constant that represents the size of the "properties" array.
	public int getMAX_PROPERTY() {
		
		return MAX_PROPERTY;
	}
	
	//Return the value of plot
	public Plot getPlot() {
		return this.plot;
	}
	
	
	// Return the name of the property
	public String getName() {
		return this.name;
	}
	
	
	//    Creates a property object by copying from another property and adds it to the "properties" array.
	public int addProperty(Property property) {
		
	//	Creates a property object by copying from another property and adds it to the "properties" array.
	       if (index < MAX_PROPERTY) {

	    	   if(property != null) {
	    		     properties[index] = property;
	    		    
	    		     return index++;
	    	   }

	       }
	       
	//Returns either -1 if the array is full, -2 if property is null, -3 if the plot is not contained by the MgmtCo plot, 
	//-4 of the plot overlaps any other property, or the index in the array where the property was added successfully.
		if(index >= MAX_PROPERTY) {
			return -1;
		
		}

		if(property == null ) {
				return -2;

		}
		 if (!this.plot.encompasses(property.getPlot())) {
	            return -3;
	         
	        }
		 
		 if (index> 0) {
	            
	            for (int i = 0; i < index; i++) {
	            	if(property != null) {
		                if (property.getPlot().overlaps(properties[i].getPlot())) {
		                    return -4;
	            	}

	                  
	                }
	            }
	        }

	        return (index - 1);

		  }

		  
	//     Creates a property object with a default plot and adds it to the "properties" array.
	public int addProperty(String name, String city, double rentAmount, String owner) {
		
		int result = 0;
		 Property property = new Property(name, city, rentAmount, owner);
		 
	       if (index < MAX_PROPERTY) {

	    	   if(property != null) {
	    		     properties[index] = property;
	    		   
	    		     index++;
	    		     return index;
	    	   }

	       }
			if(index >= MAX_PROPERTY) {
				return -1;
				
			}

			if(property == null ) {
				return -2;

			}

			 if (!this.plot.encompasses(property.getPlot())) {
				 return -3;
		        }
			 
			 if (index> 0) {
		           
		            for (int i = 0; i < index; i++) {
		            	if(property != null) {

			                if (property.getPlot().overlaps(properties[i].getPlot())) {
			                	return -4;
			                }
		            	}

		            }
		        }

			 

			  
		        return result;

	}
	
	// Creates a property object and adds it to the "properties" array.
	  public int addProperty(String propertyName, String city, double rent, String ownerName,
		      int x, int y, int width, int depth) {
		  int result = 0;
		  //create a property object.
          Property property = new Property(name, city, rent, ownerName, x, y, width,depth);
          
	       if (index < MAX_PROPERTY) {

	    	   if(property != null) {
	    		     properties[index] = property;
	    		   index++;
	    		     return index++;
	    	   }

	       }
          if (index >= MAX_PROPERTY) {
        	  return -1;
          }
				if(property == null ) {
					return -2;
				
			}
          //we have to add NOT here because property should encompasses by the management company's plot
          if (!this.plot.encompasses(property.getPlot())) {
        	  return -3;
          }
          if (index > 0) {
              for (int i = 0; i < index; i++) {
            	  if(property!=null) {
                      if (property.getPlot().overlaps(properties[i].getPlot())) {
                    	  return -4;
                      }
            	  }

              }
          }
          
          return result;
      }
        
	  
		  
  // This method accesses each "Property" object within the array "properties" and sums up the property rent and returns the total amount.
	   public double totalRent() {

		   double sum = 0.0;


	       for (int i = 0; i <MAX_PROPERTY; i++) {
	    	   
	    	   if(properties[i] != null) {
	    		   sum += properties[i].getRentalAmount();
	    	   }
	           
	       }
	       return sum;

	   }
		  
	   // This method finds the index of the property with the maximum rent amount.
		  public int maxPropertyRentIndex() {

			   int maxIndex = 0;

		       for (int i = 0; i < properties.length; i++) {

		    	   if(properties[i] !=null) {
			           if (properties[i].getRentalAmount() >= properties[maxIndex].getRentalAmount()) {

			               maxIndex = i;

			           }
		    	   }

		       }

		       return maxIndex;

			}
		  
		  
		  //      Displays the information of the property at index i
		  public String displayPropertyAtIndex(int i) {

			  
			  String result=properties[i].toString();

			  return result;
		   }
		  public String maxRentProp() {
			  
			  String result =""; 
			  result = properties[maxPropertyRentIndex()].toString();
			  
			    return result;
			  }
		  
   
//Displays the information of all the properties in the "properties" array.
		  public String toString() {

		    String allProperties = "";
		    for (int i = 0; i < properties.length; i++) {

		    	allProperties += properties[i] + "\n"; 
		    }
		    
		    double finalRent = totalRent() * mgmFeePer / 100;
		    return "List of the properties for " + getName() + ", taxID: " + taxID + "\n"
		        + "__________________________________________________" + "\n"
		        + allProperties 
		        + "__________________________________________________" + "\n"
		        + "total management Fee: " + finalRent;
		  }

	
}
