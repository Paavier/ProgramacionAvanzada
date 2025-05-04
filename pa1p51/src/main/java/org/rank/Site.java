package org.rank;

import java.util.Locale;
import java.util.Objects;

public class Site implements Comparable<Site>{

     private String name;
     private double rank;

     public Site(String name){
          this.name = name;
          this.rank = 0;
     }

     public String getName() {
          return name;
     }

     public double getRank() {
          return rank;
     }

     public void addRank(double rankIncrease){
          this.rank += rankIncrease;
     }

     @Override
     public boolean equals (Object o){
          if(this == o)
               return true;
          return (o instanceof Site parameter) && this.name.equalsIgnoreCase(parameter.name);
     }

     @Override
     public int hashCode(){
          return Objects.hash(this.name.toLowerCase());
     }

     @Override
     public int compareTo(Site otherSite){
          return this.name.compareToIgnoreCase(otherSite.name);
     }

     @Override
     public String toString(){
          return String.format(Locale.UK, this.name + "(%.5f)", this.rank);
     }
}
