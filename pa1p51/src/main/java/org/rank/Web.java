package org.rank;

import java.util.*;
import java.util.stream.Collectors;

public class Web {

     private Set<Link> links;
     protected Set<Site> sites;
     private static final double THRESHOLD = 1E-5;
     private static Random alea = new Random(1);

     public Web(){
          this.links = new HashSet<>();
          this.sites = new HashSet<>();
     }

     protected void addSite(Site site){
          this.sites.add(site);
     }

     protected void addSiteWithName(String name){
          addSite(new Site(name));
     }

     public void addLink(String dataLink){
          if(dataLink == null || dataLink.isEmpty())
               throw new IllegalArgumentException("Cadena no valida: " + dataLink);

          String[] siteNames = dataLink.split("->");

          if(!validExpresion(siteNames)) {
               throw new IllegalArgumentException("Cadena no valida: " + dataLink);
          }

          addSiteWithName(siteNames[0]);
          addSiteWithName(siteNames[1]);

          this.links.add(new Link(siteNames[0], siteNames[1]));
     }

     private boolean validExpresion (String[] siteNames){
          return siteNames.length == 2 && !siteNames[0].isEmpty() && !siteNames[1].isEmpty();
     }

     public Site getSite(String name) {
          for(Site site : this.sites){
               if(site.getName().equalsIgnoreCase(name)){
                    return site;
               }
          }

          throw new NoSuchElementException("La pagina " + name + " no ha sido encontrada");
     }

     public Set<String> getNames(){
          return this.sites.stream()
                  .map(Site::getName)
                  .collect(Collectors.toSet());
     }

     private Set<Site> getSitesLinkedFrom(Site site){
          return this.links.stream()
                  .filter(link -> link.getOrigin().equalsIgnoreCase(site.getName()))
                  .map(Link::getLinked)
                  .map(this::getSite)
                  .collect(Collectors.toSet());
     }

     protected void distribute(Site site, double prize){
          double halfprize = prize/2;
          double prizePerLinkedSite;

          if(prize >= THRESHOLD){
               site.addRank(halfprize);
               Set<Site> linkedSites = getSitesLinkedFrom(site);
               if(!linkedSites.isEmpty()) {
                    prizePerLinkedSite = halfprize / linkedSites.size();
                    for (Site linkedSite : linkedSites) {
                         distribute(linkedSite, prizePerLinkedSite);
                    }
               }
          }
     }

     public void click(String name){
          try {
               distribute(getSite(name), 1);
          }catch (NoSuchElementException ignored){
               //this exception is ignored on purpose
          }
     }

     public void simulateClick(int numClick){
          List<Site> sitesAvailable = new ArrayList<>(this.sites);
          if(!sitesAvailable.isEmpty()){
               for(int i = 0; i < numClick; i++){
                    int randomIndex = alea.nextInt(sitesAvailable.size());
                    click(sitesAvailable.get(randomIndex).getName());
               }
          }
     }

     public SortedSet<Site> getSitesByName(){
           return new TreeSet<>(this.sites);
     }

     public SortedSet<Site> getSitesByRank(){
          SortedSet<Site> siteSortedSet = new TreeSet<>(Comparator.comparingDouble(Site::getRank)
                  .reversed()
                  .thenComparing(Comparator.naturalOrder()));

          siteSortedSet.addAll(this.sites);
          return siteSortedSet;
     }

     @Override
     public String toString(){
          return "Web(" + this.sites + ", " + this.links +")";
     }
}
