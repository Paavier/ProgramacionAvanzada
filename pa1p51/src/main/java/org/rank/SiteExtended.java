package org.rank;

public class SiteExtended extends Site{

     private boolean valid;

      public SiteExtended(String name){
           super(name);
           valid = true;
      }

      public void setValid(boolean valid){
           this.valid = valid;
      }

      public boolean isValid(){
           return this.valid;
      }

      @Override
      public String toString(){
           return super.toString() + (this.isValid() ? "" : "*");
      }
}
