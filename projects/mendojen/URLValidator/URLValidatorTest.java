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
	   String[] testValidUrl= {"www.amazon.com",
			   				  "www.google.com",
			   				  "http://www.go.com",
			   				  "http://yahoo.com",
			   				  "http://www.amazon.com:65535",
			   				  "http://www.amazon.com:80",
			   				  "http://www.amazon.com/test1",
			   				  "http://www.amazon.com/test1/file",
			   				  "http://www.amazon.com?action=edit&mode=up",
	   						  "http://www.amazon.com?action=edit&mode=up"};

	   String[] testInvalidUrl= {"http://www.amazšn.com",
			   					"www.amazon.comhttp://",
			   					"www.google",
			   					"h2p:/www.go.com",
			   					"http://google.4a",
			   					"http://yahoo.arr",
			   					"http://www.amazon.com:65d",
			   					"http://www.amazon.com:-9",
			   					"http://www.amazon.com//",
			   					"http://www.amazon.com/test1/..",
			   					"http://www.amazon.com&34",
								"http://www.amazon.com>action"};	   
	   int i;      
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   boolean result;
	   //URL Validation

	   for (i=0; i<testValidUrl.length;i++)
	   {
		   System.out.println("Testing valid URL address:"+testValidUrl[i]);
		   result= urlVal.isValid(testValidUrl[i]);
		   if (result)
		   { 
			   System.out.println("Valid URL:"+testValidUrl[i]+" Pass");
		   }
		   else {
			   		System.out.println("Valid URL:"+testValidUrl[i]+" Fail");
		   }

	   }
	   System.out.println();
	   for (i=0; i<testInvalidUrl.length;i++)
	   {
		   System.out.println("Testing invalid URL address:"+testInvalidUrl[i]);
		   result= urlVal.isValid(testInvalidUrl[i]);
		   if (!result)
		   { 
			   System.out.println("Invalid URL:"+testInvalidUrl[i]+" Pass");
		   }
		   else {
			   		System.out.println("Invalid URL:"+testInvalidUrl[i]+" Fail");
		   }

	   }
	System.out.println("Test Completed");
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
