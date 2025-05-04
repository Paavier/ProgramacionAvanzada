package org.rank;

import java.util.Objects;

public class Link {

     private String origin;
     private String linked;

     public Link(String origin, String linked){
          this.origin = origin;
          this.linked = linked;
     }

     public String getOrigin() {
          return origin;
     }

     public String getLinked() {
          return linked;
     }

     @Override
     public boolean equals(Object o){
          if(this == o)
               return true;
          return (o instanceof Link otherLink) && this.origin.equalsIgnoreCase(otherLink.origin) && this.linked.equalsIgnoreCase(otherLink.linked);
     }

     @Override
     public int hashCode(){
          return Objects.hash(this.origin.toLowerCase(), this.linked.toLowerCase());
     }

     @Override
     public String toString(){
          return this.origin + "->" + this.linked;
     }
}
