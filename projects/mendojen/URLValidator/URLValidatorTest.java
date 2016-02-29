/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import junit.framework.TestCase;

/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   //IsValid tests
   public void testManualTest()
   {
	  	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
  	   boolean result;
         //URL Validation
  	   System.out.println("****Testing valid URL address www.amazon.com");
  	   result= urlVal.isValid("http://www.amazon.com");
  	   if (result)
  	   { 
  		   System.out.println("Valid URL...Pass");
  	   }
  	   else {
  		   System.out.println("Valid URL...Fail");
  	   }
  	   System.out.println("www.google.com");
  	   result= urlVal.isValid("http://www.google.com");
  	   if (result)
  	   { 
  		   System.out.println("Valid URL...Pass");
  	   }
  	   else {
  		   System.out.println("Valid URL...Fail");
  	   }
  	   System.out.println("****Testing invalid ASCII character in URL address (http://www.amazšn.com)");
  	   result= urlVal.isValid("http://www.amazšn.com");
  	   if (!result)
  	   { 
  		   System.out.println("Invalid ASCII Character...Pass");
  	   }
  	   else {
  		   System.out.println("Invalid ASCII Character...Fail");
  	   }
  	   System.out.println("****Testing invalid URL pattern (www.amazon.comhttp://)");
  	   result= urlVal.isValid("www.amazon.comhttp://");
  	   if (!result)
  	   { 
  		   System.out.println("Invalid URL Pattern...Pass");
  	   }
  	   else {
  		   System.out.println("Invalid URL Pattern...Fail");
  	   }
  	   System.out.println("www.google");
  	   result= urlVal.isValid("www.google");
  	   if (!result)
  	   { 
  		   System.out.println("Invalid URL Pattern...Pass");
  	   }
  	   else {
  		   System.out.println("Invalid URL Pattern...Fail");
  	   }
  	   System.out.println("****Testing valid schemes (http://www.google.com");
  	   result= urlVal.isValid("http://www.google.com");
  	   if(result)
  	   { 
  		   System.out.println("Valid Scheme...Pass");
  	   }
  	   else {
  		   System.out.println("Valid Scheme...Fail");
  	   }
  	   System.out.println("http://www.go.com");
  	   result= urlVal.isValid("http://www.go.com");
  	   if(result)
  	   { 
  		   System.out.println("Valid Scheme...Pass");
  	   }
  	   else {
  		   System.out.println("Valid Scheme...Fail");
  	   }
  	   System.out.println("****Testing invalid schemes (http//www.google.com");
  	   result= urlVal.isValid("http//www.google.com");
  	   if(!result)
  	   { 
  		   System.out.println("Invalid Scheme...Pass");
  	   }
  	   else {
  		   System.out.println("Invalid Scheme...Fail");
  	   }
  	   System.out.println("h2p:/www.go.com");
  	   result= urlVal.isValid("h2p:/www.go.com");
  	   if(!result)
  	   { 
  		   System.out.println("Invalid Scheme...Pass");
  	   }
  	   else {
  		   System.out.println("Invalid Scheme...Fail");
  	   }
  	   System.out.println("****Testing valid authority (http://go.com)");
  	   result= urlVal.isValid("http://go.com");
  	   if(result)
  	   { 
  		   System.out.println("Valid Authority...Pass");
  	   }
  	   else {
  		   System.out.println("Valid Authority...Fail");
  	   }
  	   System.out.println("http://yahoo.com");
  	   result= urlVal.isValid("http://yahoo.com");
  	   if(result)
  	   { 
  		   System.out.println("Valid Authority...Pass");
  	   }
  	   else {
  		   System.out.println("Valid Authority...Fail");
  	   }
  	   System.out.println("****Testing invalid authority (http://google.4a)");
  	   result= urlVal.isValid("http://google.4a");
  	   if(!result)
  	   { 
  		   System.out.println("Invalid Authority...Pass");
  	   }
  	   else {
  		   System.out.println("Invalid Authority...Fail");
  	   }
  	   System.out.println("http://yahoo.arr");
  	   result= urlVal.isValid("http://yahoo.arr");
  	   if(!result)
  	   { 
  		   System.out.println("Invalid Authority...Pass");
  	   }
  	   else {
  		   System.out.println("Invalid Authority...Fail");
  	   }
  	   System.out.println("****Testing valid port (http://www.amazon.com:65535)");
  	   //bug!
  	   result= urlVal.isValid("http://www.amazon.com:65535");
  	   if(result)
  	   { 
  		   System.out.println("Valid Port...Pass");
  	   }
  	   else {
  		   System.out.println("Valid Port...Fail");
  	   }
  	   System.out.println("http://www.amazon.com:80");
  	   result= urlVal.isValid("http://www.amazon.com:80");
  	   if(result)
  	   { 
  		   System.out.println("Valid Port...Pass");
  	   }
  	   else {
  		   System.out.println("Valid Port...Fail");
  	   }
  	 System.out.println("****Testing invalid port (http://www.amazon.com:65d)");
	   //bug!
	   result= urlVal.isValid("http://www.amazon.com:65d");
	   if(!result)
	   { 
		   System.out.println("Invalid Port...Pass");
	   }
	   else {
		   System.out.println("Invalid Port...Fail");
	   }
	   System.out.println("http://www.amazon.com:-9");
	   result= urlVal.isValid("http://www.amazon.com:-9");
	   if(!result)
	   { 
		   System.out.println("Invalid Port...Pass");
	   }
	   else {
		   System.out.println("Invalid Port...Fail");
	   }
  	   System.out.println("****Testing valid path (http://www.amazon.com/test1)");
  	   result= urlVal.isValid("http://www.amazon.com/test1");
  	   if(result)
  	   { 
  		   System.out.println("Valid Path...Pass");
  	   }
  	   else {
  		   System.out.println("Valid Path...Fail");
  	   }
  	   System.out.println("http://www.amazon.com/test1/file");
  	   result= urlVal.isValid("http://www.amazon.com/test1/file");
  	   if(result)
  	   { 
  		   System.out.println("Valid Path...Pass");
  	   }
  	   else {
  		   System.out.println("Valid Path...Fail");
  	   }
  	 System.out.println("****Testing invalid path (http://www.amazon.com//)");
	   result= urlVal.isValid("http://www.amazon.com//");
	   if(!result)
	   { 
		   System.out.println("Invalid Path...Pass");
	   }
	   else {
		   System.out.println("Invalid Path...Fail");
	   }
	   System.out.println("http://www.amazon.com/test1/..");
	   result= urlVal.isValid("http://www.amazon.com/test1/..");
	   if(!result)
	   { 
		   System.out.println("Invalid Path...Pass");
	   }
	   else {
		   System.out.println("Invalid Path...Fail");
	   }
  	   System.out.println("****Testing valid query (http://www.amazon.com?action=view)");
  	   result= urlVal.isValid("http://www.amazon.com?action=view");
  	   if(result)
  	   { 
  		   System.out.println("Valid Query...Pass");
  	   }
  	   else {
  		   System.out.println("Valid Query...Fail");
  	   }
  	   System.out.println("http://www.amazon.com?action=edit&mode=up");
  	   result= urlVal.isValid("http://www.amazon.com?action=edit&mode=up");
  	   if(result)
  	   { 
  		   System.out.println("Valid Query...Pass");
  	   }
  	   else {
  		   System.out.println("Valid Query...Fail");
  	   }
  	   System.out.println("****Testing invalid query (http://www.amazon.com&34)");
	   result= urlVal.isValid("http://www.amazon.com&34");
	   if(!result)
	   { 
		   System.out.println("Invalid Query...Pass");
	   }
	   else {
		   System.out.println("Invalid Query...Fail");
	   }
	   System.out.println("http://www.amazon.com>action");
	   result= urlVal.isValid("http://www.amazon.com>action");
	   if(!result)
	   { 
		   System.out.println("Invalid Query...Pass");
	   }
	   else {
		   System.out.println("Invalid Query...Fail");
	   }
	   System.out.println("****Manual Tests Completed****");
   }

   //Randomized Testing   
   public class RandomUrlValidatorTest extends TestCase {
   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   //IsValid tests
   public void testRandomTest()
   {
   }

   }

   //Partition testing
   public void testYourFirstPartition()
   {
	   
   }
   
   public void testYourSecondPartition(){
	   
   }
   
   
   public void testIsValid()
   {
       //call manual tests
       UrlValidatorTest;

	   for(int i = 0;i<10000;i++)
	   {
		   
	   }
   }
   
   public void testAnyOtherUnitTest()
   {
	   
   }
   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */
   

}