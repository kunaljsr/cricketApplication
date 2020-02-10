package com.example.Match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchInput {
   private  String teamOne;
   private String teamTwo;
   private String matchType ;
   private  String date;

   public MatchInput()
   {}

   public String getTeamOne() {
      return teamOne;
   }

   public void setTeamOne(String teamOne) {
      this.teamOne = teamOne;
   }

   public String getTeamTwo() {
      return teamTwo;
   }

   public void setTeamTwo(String teamTwo) {
      this.teamTwo = teamTwo;
   }

   public String getMatchType() {
      return matchType;
   }

   public void setMatchType(String matchType) {
      this.matchType = matchType;
   }

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }


}
