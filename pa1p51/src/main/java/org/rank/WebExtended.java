package org.rank;

public class WebExtended extends Web{

     public WebExtended(){
          super();
     }

     @Override
     protected void addSiteWithName(String name){
          super.addSite(new SiteExtended(name));
     }

     @Override
     protected void distribute(Site site, double prize){
          SiteExtended siteExtended = (SiteExtended) site;
          if(siteExtended.isValid())
               super.distribute(siteExtended, prize);
     }

     protected void switchSiteWithName(String name){
          Site site = super.getSite(name);
          SiteExtended siteExtended = (SiteExtended) site;
          siteExtended.setValid(!siteExtended.isValid());
     }
}
