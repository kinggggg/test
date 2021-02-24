package com.zeek.pattern.chain;

public class FileLogger extends com.zeek.springcloudgatewayservice.chain.AbstractLogger {
 
   public FileLogger(int level){
      this.level = level;
   }
 
   @Override
   protected void write(String message) {    
      System.out.println("File::Logger: " + message);
   }
}