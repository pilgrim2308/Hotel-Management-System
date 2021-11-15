-- MariaDB dump 10.17  Distrib 10.5.6-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: DBMS
-- ------------------------------------------------------
-- Server version	10.5.6-MariaDB
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO,POSTGRESQL' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table "Allotted_to"
--

DROP TABLE IF EXISTS "Allotted_to";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Allotted_to" (
  "Cust_ID" varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  "ROOM_ID" varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY ("Cust_ID","ROOM_ID"),
  KEY "ROOM_ID" ("ROOM_ID"),
  CONSTRAINT "Allotted_to_ibfk_1" FOREIGN KEY ("Cust_ID") REFERENCES "Customer" ("Cust_ID"),
  CONSTRAINT "Allotted_to_ibfk_2" FOREIGN KEY ("ROOM_ID") REFERENCES "Room" ("Room_No")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Allotted_to"
--

LOCK TABLES "Allotted_to" WRITE;
/*!40000 ALTER TABLE "Allotted_to" DISABLE KEYS */;
/*!40000 ALTER TABLE "Allotted_to" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "Bank_Detail"
--

DROP TABLE IF EXISTS "Bank_Detail";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Bank_Detail" (
  "Bank_ID" varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Bank_Name" varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Account_Number" varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  "IFSC_Code" varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY ("Bank_ID")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Bank_Detail"
--

LOCK TABLES "Bank_Detail" WRITE;
/*!40000 ALTER TABLE "Bank_Detail" DISABLE KEYS */;
/*!40000 ALTER TABLE "Bank_Detail" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "Bill"
--

DROP TABLE IF EXISTS "Bill";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Bill" (
  "Bill_No" int(11) NOT NULL,
  "Price" int(11) NOT NULL,
  "Booking_ID" varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Order_No" int(11) DEFAULT NULL,
  "Coupan_ID" varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY ("Bill_No","Booking_ID"),
  KEY "Booking_ID" ("Booking_ID"),
  KEY "Order_No" ("Order_No"),
  KEY "Coupan_ID" ("Coupan_ID"),
  CONSTRAINT "Bill_ibfk_1" FOREIGN KEY ("Booking_ID") REFERENCES "Booking" ("Booking_ID"),
  CONSTRAINT "Bill_ibfk_2" FOREIGN KEY ("Order_No") REFERENCES "Food_Orders" ("Order_No"),
  CONSTRAINT "Bill_ibfk_3" FOREIGN KEY ("Coupan_ID") REFERENCES "Coupon" ("Coupan_ID")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Bill"
--

LOCK TABLES "Bill" WRITE;
/*!40000 ALTER TABLE "Bill" DISABLE KEYS */;
INSERT INTO "Bill" VALUES (1,10000,'book_acbf9c1f5-9ecb-4cd3-81b0-1b4d657c4306',0,NULL),(2,16000,'book_adfe77ad3-6ce1-47d5-bd19-84997050fd9d',0,NULL),(3,31000,'book_a5fdb5f0c-16d7-419b-8ae9-fb4cd0da6b42',0,NULL),(4,31000,'book_a26e9850f-4e79-424f-a499-3fcb95484bca',0,NULL),(5,78,'book_a6dd72414-54e0-4aa1-b38e-e004e920693b',2,NULL),(6,78,'book_a6dd72414-54e0-4aa1-b38e-e004e920693b',3,NULL),(7,117,'book_a6dd72414-54e0-4aa1-b38e-e004e920693b',4,NULL),(8,26000,'book_ac18000c0-0f4c-4667-a7e2-8c7b77c41669',0,NULL),(9,338,'book_a6dd72414-54e0-4aa1-b38e-e004e920693b',5,NULL),(10,21000,'book_ab6f01106-732d-4d80-98b3-bca8e9dd0c98',0,NULL),(11,6000,'book_a44060a32-f172-4848-b0ea-34e565631e91',0,NULL),(12,0,'book_a26e9850f-4e79-424f-a499-3fcb95484bca',6,NULL),(13,200,'book_a26e9850f-4e79-424f-a499-3fcb95484bca',7,NULL),(14,200,'book_a25e40e12-1f34-47df-b7e4-342591ab2232',8,NULL),(15,200,'book_a25e40e12-1f34-47df-b7e4-342591ab2232',9,NULL),(16,200,'book_a25e40e12-1f34-47df-b7e4-342591ab2232',10,NULL),(17,500,'book_a53565a19-1729-4b99-b5e5-ce764a7ed963',11,NULL),(18,200,'book_a53565a19-1729-4b99-b5e5-ce764a7ed963',12,NULL),(19,5900,'book_afd65b480-11af-4f04-9735-54d7f0e902ef',0,NULL),(20,900,'book_a53565a19-1729-4b99-b5e5-ce764a7ed963',13,NULL);
/*!40000 ALTER TABLE "Bill" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "Booking"
--

DROP TABLE IF EXISTS "Booking";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Booking" (
  "Booking_ID" varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Purpose_of_visit" varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  "No_of_members" int(11) NOT NULL,
  "Booking_Time" time NOT NULL,
  "start_date" date DEFAULT NULL,
  "End_Date" date DEFAULT NULL,
  "Booking_Date" date NOT NULL,
  "Payment_Status" varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  "Checkin" time DEFAULT NULL,
  "Checkout" time DEFAULT NULL,
  "Cust_ID" varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY ("Booking_ID"),
  KEY "Cust_ID" ("Cust_ID"),
  CONSTRAINT "Booking_ibfk_1" FOREIGN KEY ("Cust_ID") REFERENCES "Customer" ("Cust_ID")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Booking"
--

LOCK TABLES "Booking" WRITE;
/*!40000 ALTER TABLE "Booking" DISABLE KEYS */;
INSERT INTO "Booking" VALUES ('book_a25e40e12-1f34-47df-b7e4-342591ab2232','2',2,'15:57:08','2020-09-30','2020-10-14','2020-10-25','processing','18:21:37','20:11:11','a'),('book_a26e9850f-4e79-424f-a499-3fcb95484bca','namaste india',70,'15:34:46','2020-11-11','2020-11-20','2020-11-01','confirmed','19:35:32','20:04:50','a'),('book_a44060a32-f172-4848-b0ea-34e565631e91','namaste india',4,'23:23:00','2020-11-04','2020-11-21','2020-11-11','confirmed',NULL,NULL,'a'),('book_a4644cce7-f109-4e02-bdb3-e6e18fa030a8','2ded',2,'23:51:03','2020-10-07','2020-10-24','2020-10-29','confirmed',NULL,NULL,'a'),('book_a53565a19-1729-4b99-b5e5-ce764a7ed963','namaste india',2,'23:36:56','2020-10-07','2020-10-01','2020-10-29','confirmed','20:16:37',NULL,'a'),('book_a5fdb5f0c-16d7-419b-8ae9-fb4cd0da6b42','namaste india',2,'18:13:30','2020-10-07','2020-10-16','2020-10-31','confirmed','18:19:14',NULL,'a'),('book_a6dd72414-54e0-4aa1-b38e-e004e920693b','2',1,'23:41:33','2020-10-07','2020-10-10','2020-10-29','confirmed','18:07:52','18:20:38','a'),('book_a9eaaec71-6926-480c-97ba-0e8e4d47caaf','namaste india',4,'23:28:21','2020-09-30','2020-10-23','2020-10-29','confirmed',NULL,NULL,'a'),('book_ab6f01106-732d-4d80-98b3-bca8e9dd0c98','namaste india',100,'18:11:53','2020-11-11','2020-11-13','2020-11-03','confirmed',NULL,NULL,'a'),('book_ac18000c0-0f4c-4667-a7e2-8c7b77c41669','namaste india',5,'21:12:05','2020-11-11','2020-11-20','2020-11-01','confirmed',NULL,NULL,'a'),('book_acbf9c1f5-9ecb-4cd3-81b0-1b4d657c4306','2ded',2,'23:54:51','2020-10-08','2020-10-23','2020-10-29','confirmed',NULL,NULL,'a'),('book_ad0ba5e06-6357-43a4-8b24-8be863293b1c','namaste india',2,'23:34:38','2020-10-07','2020-10-22','2020-10-29','confirmed',NULL,NULL,'a'),('book_adfe77ad3-6ce1-47d5-bd19-84997050fd9d','namaste india',2,'00:08:31','2020-10-14','2020-10-23','2020-10-30','confirmed',NULL,NULL,'a'),('book_af4e8bc6d-2a77-4b8c-bc85-506e76dbc863','2',2,'15:55:39','2020-10-07','2020-10-08','2020-10-25','processing',NULL,NULL,'a'),('book_afd65b480-11af-4f04-9735-54d7f0e902ef','blah blah!!',2,'18:18:48','2020-11-04','2020-11-29','2020-11-16','confirmed',NULL,NULL,'a');
/*!40000 ALTER TABLE "Booking" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "Coupon"
--

DROP TABLE IF EXISTS "Coupon";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Coupon" (
  "Name" varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Expire_Date" date NOT NULL,
  "Discount_Amount" int(11) NOT NULL,
  "Coupan_ID" varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Description" varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  "Cust_ID" varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY ("Coupan_ID"),
  KEY "Cust_ID" ("Cust_ID"),
  CONSTRAINT "Coupon_ibfk_1" FOREIGN KEY ("Cust_ID") REFERENCES "Customer" ("Cust_ID")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Coupon"
--

LOCK TABLES "Coupon" WRITE;
/*!40000 ALTER TABLE "Coupon" DISABLE KEYS */;
INSERT INTO "Coupon" VALUES ('Novbon','2020-11-30',100,'Novbon_2020-11-30','100 rs off on everything',NULL);
/*!40000 ALTER TABLE "Coupon" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "Customer"
--

DROP TABLE IF EXISTS "Customer";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Customer" (
  "Cust_ID" varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  "FIrst_Name" varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Last_Name" varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  "DOB" date NOT NULL DEFAULT '1999-11-11',
  "House_No" varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Street" varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  "city" varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Pincode" int(11) NOT NULL,
  "DP_URL" varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  "Age" int(11) DEFAULT NULL,
  "Bank_Ref_No" varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY ("Cust_ID"),
  KEY "Bank_Ref_No" ("Bank_Ref_No"),
  CONSTRAINT "Customer_ibfk_1" FOREIGN KEY ("Bank_Ref_No") REFERENCES "Bank_Detail" ("Bank_ID")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Customer"
--

LOCK TABLES "Customer" WRITE;
/*!40000 ALTER TABLE "Customer" DISABLE KEYS */;
INSERT INTO "Customer" VALUES ('a','arpit','mehta','2020-07-21','jb','patel nagar,saharanpur','saharanpur',247001,'null',NULL,NULL),('a1','arpit','mehta','2020-09-30','d','1/99,patel nagar,saharanpur','saharanpur',247001,'null',NULL,NULL),('a12','arpit','mehta','2020-09-30','ss','1/99,patel nagar,saharanpur','saharanpur',247001,'null',NULL,NULL),('a122','arpit','mehta','2020-09-30','d','1/99,patel nagar,saharanpur','saharanpur',247001,'null',NULL,NULL),('a1222','arpit','mehta','2020-09-30','d','1/99,patel nagar,saharanpur','saharanpur',247001,'null',NULL,NULL),('a123','arpit','mehta','2020-09-30','ss','1/99,patel nagar,saharanpur','saharanpur',247001,'null',NULL,NULL),('anshul','arpit','mehta','2020-09-29','d','1/99,patel nagar,saharanpur','saharanpur',247001,'null',NULL,NULL),('ar','arpit','mehta','2020-09-29','w2','1/99,patel nagar,saharanpur','saharanpur',247001,'null',NULL,NULL),('ccd','arpit','mehta','2020-10-14','wd','1/99,patel nagar,saharanpur','saharanpur',247001,'null',NULL,NULL),('d','D','D','1111-11-11','D','D','d',1,'D',NULL,NULL),('gavo1','arpit','mehta','2020-06-11','e','1/99,patel nagar,saharanpur','saharanpur',247001,'null',NULL,NULL),('gavow3','arpit','mehta','2020-09-30','s','1/99,patel nagar,saharanpur','saharanpur',247001,'null',NULL,NULL),('wee','arpit','mehta','2020-09-30','d','1/99,patel nagar,saharanpur','saharanpur',247001,'null',NULL,NULL);
/*!40000 ALTER TABLE "Customer" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "Customer_Email"
--

DROP TABLE IF EXISTS "Customer_Email";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Customer_Email" (
  "Email" varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Cust_ID" varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY ("Email","Cust_ID"),
  KEY "Cust_ID" ("Cust_ID"),
  CONSTRAINT "Customer_Email_ibfk_1" FOREIGN KEY ("Cust_ID") REFERENCES "Customer" ("Cust_ID")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Customer_Email"
--

LOCK TABLES "Customer_Email" WRITE;
/*!40000 ALTER TABLE "Customer_Email" DISABLE KEYS */;
INSERT INTO "Customer_Email" VALUES ('arpitmehta43.am@gmail.com.in','a');
/*!40000 ALTER TABLE "Customer_Email" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "Customer_Phone"
--

DROP TABLE IF EXISTS "Customer_Phone";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Customer_Phone" (
  "Phone_Number" varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Cust_ID" varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY ("Phone_Number","Cust_ID"),
  KEY "Cust_ID" ("Cust_ID"),
  CONSTRAINT "Customer_Phone_ibfk_1" FOREIGN KEY ("Cust_ID") REFERENCES "Customer" ("Cust_ID")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Customer_Phone"
--

LOCK TABLES "Customer_Phone" WRITE;
/*!40000 ALTER TABLE "Customer_Phone" DISABLE KEYS */;
/*!40000 ALTER TABLE "Customer_Phone" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "Employee"
--

DROP TABLE IF EXISTS "Employee";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Employee" (
  "Employee_ID" varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  "First_Name" varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Last_Name" varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  "DOB" date NOT NULL,
  "Age" int(11) DEFAULT NULL,
  "House_No" varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Street" varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  "city" varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Pincode" int(11) NOT NULL,
  "Salary" int(11) DEFAULT NULL,
  "Joining_Date" date NOT NULL,
  "DP_URL" varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  "Current_status" varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  "Attendance" varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  "gender" varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  "Bank_Ref_No" varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  "priviledge_level" int(11) DEFAULT NULL,
  PRIMARY KEY ("Employee_ID"),
  KEY "Bank_Ref_No" ("Bank_Ref_No"),
  CONSTRAINT "Employee_ibfk_1" FOREIGN KEY ("Bank_Ref_No") REFERENCES "Bank_Detail" ("Bank_ID")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Employee"
--

LOCK TABLES "Employee" WRITE;
/*!40000 ALTER TABLE "Employee" DISABLE KEYS */;
INSERT INTO "Employee" VALUES ('arpitmehta','arpit','mehta','1999-11-11',NULL,'1/99','patel','sre',247001,NULL,'2010-11-11',NULL,NULL,NULL,NULL,NULL,NULL),('emp_anshul','anshul','mehta','2020-10-22',19,'1/99','patel nagar,saharanpur','saharanpur',247001,10000,'2020-10-26','null','free','present','Male',NULL,1);
/*!40000 ALTER TABLE "Employee" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "Employee_Email"
--

DROP TABLE IF EXISTS "Employee_Email";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Employee_Email" (
  "Email" varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Employee_ID" varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY ("Email","Employee_ID"),
  KEY "Employee_ID" ("Employee_ID"),
  CONSTRAINT "Employee_Email_ibfk_1" FOREIGN KEY ("Employee_ID") REFERENCES "Employee" ("Employee_ID")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Employee_Email"
--

LOCK TABLES "Employee_Email" WRITE;
/*!40000 ALTER TABLE "Employee_Email" DISABLE KEYS */;
/*!40000 ALTER TABLE "Employee_Email" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "Employee_Phone"
--

DROP TABLE IF EXISTS "Employee_Phone";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Employee_Phone" (
  "Phone_No" varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Employee_ID" varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY ("Phone_No","Employee_ID"),
  KEY "Employee_ID" ("Employee_ID"),
  CONSTRAINT "Employee_Phone_ibfk_1" FOREIGN KEY ("Employee_ID") REFERENCES "Employee" ("Employee_ID")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Employee_Phone"
--

LOCK TABLES "Employee_Phone" WRITE;
/*!40000 ALTER TABLE "Employee_Phone" DISABLE KEYS */;
/*!40000 ALTER TABLE "Employee_Phone" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "Feedback"
--

DROP TABLE IF EXISTS "Feedback";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Feedback" (
  "Feedback_ID" varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Service_Rating" int(11) DEFAULT NULL,
  "Hotel_Rating" int(11) DEFAULT NULL,
  "Comments" varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  "Date" date NOT NULL,
  "Time" time NOT NULL,
  "Booking_ID" varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Cust_ID" varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY ("Feedback_ID"),
  KEY "Booking_ID" ("Booking_ID"),
  KEY "Cust_ID" ("Cust_ID"),
  CONSTRAINT "Feedback_ibfk_1" FOREIGN KEY ("Booking_ID") REFERENCES "Booking" ("Booking_ID"),
  CONSTRAINT "Feedback_ibfk_2" FOREIGN KEY ("Cust_ID") REFERENCES "Customer" ("Cust_ID")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Feedback"
--

LOCK TABLES "Feedback" WRITE;
/*!40000 ALTER TABLE "Feedback" DISABLE KEYS */;
INSERT INTO "Feedback" VALUES ('a18:34:54',2,3,'It as ok','2020-11-10','18:34:54','book_a26e9850f-4e79-424f-a499-3fcb95484bca','a'),('a18:35:32',5,5,'It as ok','2020-11-10','18:35:32','book_ac18000c0-0f4c-4667-a7e2-8c7b77c41669','a');
/*!40000 ALTER TABLE "Feedback" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "Food_Item"
--

DROP TABLE IF EXISTS "Food_Item";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Food_Item" (
  "Name" varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Food_item_id" varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Description" varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  "Price" int(11) DEFAULT NULL,
  PRIMARY KEY ("Food_item_id")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Food_Item"
--

LOCK TABLES "Food_Item" WRITE;
/*!40000 ALTER TABLE "Food_Item" DISABLE KEYS */;
INSERT INTO "Food_Item" VALUES ('Sandwiches','f1','Cheese and corn sandwiches,filled with exotic spices',199),('coffee','f10','hot coffee',39),('icecream','f11','vanilla and chocolate ice cream',39),('chicken','f12','Butter chicken, non veg',390),('roti','f13','whole grain roti ',20),('paranthaa','f2','aloo paranthaas with cheese',100),('gobhi paranthaa','f3','gobhi paranthaas with cheese',100),('Indian platter','f4','3 sabzis with 3 roti and salad',450),('chinese platter','f5','chowmein with 2 veg rolls',400),('pizza','f6','capsicum,corn and cheese pizza, serves 3',300),('Burger','f7','veg cheese burger',200),('Tea','f8','hot tea',39);
/*!40000 ALTER TABLE "Food_Item" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "Food_Orders"
--

DROP TABLE IF EXISTS "Food_Orders";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Food_Orders" (
  "Order_No" int(11) NOT NULL,
  "Status" varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Total_Price" int(11) NOT NULL,
  "Date" date DEFAULT NULL,
  "Time" time DEFAULT NULL,
  "ROOM_ID" varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY ("Order_No"),
  KEY "ROOM_ID" ("ROOM_ID"),
  CONSTRAINT "Food_Orders_ibfk_1" FOREIGN KEY ("ROOM_ID") REFERENCES "Room" ("Room_No")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Food_Orders"
--

LOCK TABLES "Food_Orders" WRITE;
/*!40000 ALTER TABLE "Food_Orders" DISABLE KEYS */;
INSERT INTO "Food_Orders" VALUES (0,'completed',0,NULL,NULL,NULL),(2,'null',78,'2020-11-01','18:12:09','R101'),(3,'null',78,'2020-11-01','18:14:21','R101'),(4,'null',117,'2020-11-01','18:14:26','R101'),(5,'null',338,'2020-11-01','21:13:14','R101'),(6,'null',100,'2020-11-12','21:02:58','R101'),(7,'null',200,'2020-11-13','18:17:09','R101'),(8,'null',200,'2020-11-13','18:21:58','R102'),(9,'null',200,'2020-11-13','20:08:53','R102'),(10,'null',200,'2020-11-13','20:10:44','R102'),(11,'Completed',600,'2020-11-16','00:28:01','R101'),(12,'Completed',200,'2020-11-16','00:28:31','R101'),(13,'placed',900,'2020-11-16','18:21:12','R101');
/*!40000 ALTER TABLE "Food_Orders" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "Inventory"
--

DROP TABLE IF EXISTS "Inventory";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Inventory" (
  "Quantity" int(11) NOT NULL,
  "Inventory_ID" int(11) NOT NULL,
  "Current_Incharge" varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY ("Inventory_ID"),
  KEY "Current_Incharge" ("Current_Incharge"),
  CONSTRAINT "Inventory_ibfk_1" FOREIGN KEY ("Current_Incharge") REFERENCES "Employee" ("Employee_ID")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Inventory"
--

LOCK TABLES "Inventory" WRITE;
/*!40000 ALTER TABLE "Inventory" DISABLE KEYS */;
/*!40000 ALTER TABLE "Inventory" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "Invoice"
--

DROP TABLE IF EXISTS "Invoice";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Invoice" (
  "Invoice_ID" varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Date" date DEFAULT NULL,
  "Time" time DEFAULT NULL,
  "Amount" int(11) DEFAULT NULL,
  "Tax_Applied" int(11) DEFAULT NULL,
  "Cust_ID" varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  "payment_ID" varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY ("Invoice_ID"),
  KEY "Cust_ID" ("Cust_ID"),
  KEY "payment_ID" ("payment_ID"),
  CONSTRAINT "Invoice_ibfk_1" FOREIGN KEY ("Cust_ID") REFERENCES "Customer" ("Cust_ID"),
  CONSTRAINT "Invoice_ibfk_2" FOREIGN KEY ("payment_ID") REFERENCES "Payment" ("payment_ID")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Invoice"
--

LOCK TABLES "Invoice" WRITE;
/*!40000 ALTER TABLE "Invoice" DISABLE KEYS */;
INSERT INTO "Invoice" VALUES ('a_00:08:37','2020-10-30','00:08:37',16000,10,'a','a_00:08:37'),('a_00:28:08','2020-11-16','00:28:08',500,10,'a','a_00:28:08'),('a_15:34:55','2020-11-01','15:34:55',31000,10,'a','a_15:34:55'),('a_18:12:01','2020-11-03','18:12:01',21000,10,'a','a_18:12:01'),('a_18:13:40','2020-10-31','18:13:40',31000,10,'a','a_18:13:40'),('a_18:14:35','2020-11-01','18:14:35',117,10,'a','a_18:14:35'),('a_18:19:27','2020-11-16','18:19:27',5900,10,'a','a_18:19:27'),('a_18:35:49','2020-11-13','18:35:49',200,10,'a','a_18:35:49'),('a_20:03:05','2020-11-13','20:03:05',200,10,'a','a_20:03:05'),('a_20:09:10','2020-11-13','20:09:10',200,10,'a','a_20:09:10'),('a_20:11:18','2020-11-13','20:11:18',200,10,'a','a_20:11:18'),('a_21:03:14','2020-11-12','21:03:14',0,10,'a','a_21:03:14'),('a_21:12:15','2020-11-01','21:12:15',26000,10,'a','a_21:12:15'),('a_23:23:15','2020-11-11','23:23:15',6000,10,'a','a_23:23:15'),('a_23:55:01','2020-10-29','23:55:01',10000,10,'a','a_23:55:01');
/*!40000 ALTER TABLE "Invoice" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "Order_item"
--

DROP TABLE IF EXISTS "Order_item";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Order_item" (
  "Quantity" int(11) NOT NULL,
  "item_ID" int(11) NOT NULL,
  "Order_No" int(11) NOT NULL,
  "Food_item_id" varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY ("item_ID","Order_No"),
  KEY "Order_No" ("Order_No"),
  KEY "Food_item_id" ("Food_item_id"),
  CONSTRAINT "Order_item_ibfk_1" FOREIGN KEY ("Order_No") REFERENCES "Food_Orders" ("Order_No"),
  CONSTRAINT "Order_item_ibfk_2" FOREIGN KEY ("Food_item_id") REFERENCES "Food_Item" ("Food_item_id")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Order_item"
--

LOCK TABLES "Order_item" WRITE;
/*!40000 ALTER TABLE "Order_item" DISABLE KEYS */;
INSERT INTO "Order_item" VALUES (2,1,2,'f11'),(2,2,3,'f10'),(3,3,4,'f10'),(1,4,5,'f1'),(1,5,5,'f10'),(1,6,5,'f3'),(1,7,6,'f2'),(2,8,7,'f2'),(1,9,8,'f7'),(1,10,9,'f7'),(1,11,10,'f7'),(2,12,11,'f6'),(1,13,12,'f7'),(3,14,13,'f6');
/*!40000 ALTER TABLE "Order_item" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "Payment"
--

DROP TABLE IF EXISTS "Payment";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Payment" (
  "payment_ID" varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Status" varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  "type" varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  "Mode_of_payment" varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  "amount" int(11) NOT NULL,
  "Date" date NOT NULL,
  "Time" time NOT NULL,
  "bill_no" int(11) DEFAULT NULL,
  "Booking_ID" varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  "Cust_ID" varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY ("payment_ID"),
  KEY "Bill_No" ("bill_no","Booking_ID"),
  KEY "Cust_ID" ("Cust_ID"),
  CONSTRAINT "Payment_ibfk_1" FOREIGN KEY ("Bill_No", "Booking_ID") REFERENCES "Bill" ("Bill_No", "Booking_ID"),
  CONSTRAINT "Payment_ibfk_2" FOREIGN KEY ("Cust_ID") REFERENCES "Customer" ("Cust_ID")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Payment"
--

LOCK TABLES "Payment" WRITE;
/*!40000 ALTER TABLE "Payment" DISABLE KEYS */;
INSERT INTO "Payment" VALUES ('a_00:08:37','processing','debit','online',16000,'2020-10-30','00:08:37',2,'book_adfe77ad3-6ce1-47d5-bd19-84997050fd9d','a'),('a_00:28:08','processing','debit','online',500,'2020-11-16','00:28:08',17,'book_a53565a19-1729-4b99-b5e5-ce764a7ed963','a'),('a_15:34:55','processing','debit','online',31000,'2020-11-01','15:34:55',4,'book_a26e9850f-4e79-424f-a499-3fcb95484bca','a'),('a_18:12:01','processing','debit','online',21000,'2020-11-03','18:12:01',10,'book_ab6f01106-732d-4d80-98b3-bca8e9dd0c98','a'),('a_18:13:40','processing','debit','online',31000,'2020-10-31','18:13:40',3,'book_a5fdb5f0c-16d7-419b-8ae9-fb4cd0da6b42','a'),('a_18:14:35','processing','debit','online',117,'2020-11-01','18:14:35',7,'book_a6dd72414-54e0-4aa1-b38e-e004e920693b','a'),('a_18:19:27','completed','debit','online',5900,'2020-11-16','18:19:27',19,'book_afd65b480-11af-4f04-9735-54d7f0e902ef','a'),('a_18:35:49','initiated','debit','debit',200,'2020-11-13','18:35:49',13,'book_a26e9850f-4e79-424f-a499-3fcb95484bca','a'),('a_20:03:05','initiated','debit','debit',200,'2020-11-13','20:03:05',14,'book_a25e40e12-1f34-47df-b7e4-342591ab2232','a'),('a_20:09:10','initiated','debit','debit',200,'2020-11-13','20:09:10',15,'book_a25e40e12-1f34-47df-b7e4-342591ab2232','a'),('a_20:11:18','initiated','debit','debit',200,'2020-11-13','20:11:18',16,'book_a25e40e12-1f34-47df-b7e4-342591ab2232','a'),('a_21:03:14','processing','debit','online',0,'2020-11-12','21:03:14',12,'book_a26e9850f-4e79-424f-a499-3fcb95484bca','a'),('a_21:12:15','processing','debit','online',26000,'2020-11-01','21:12:15',8,'book_ac18000c0-0f4c-4667-a7e2-8c7b77c41669','a'),('a_23:23:15','processing','debit','online',6000,'2020-11-11','23:23:15',11,'book_a44060a32-f172-4848-b0ea-34e565631e91','a'),('a_23:55:01','processing','debit','online',10000,'2020-10-29','23:55:01',1,'book_acbf9c1f5-9ecb-4cd3-81b0-1b4d657c4306','a'),('emp_anshul_17:12:38','Confirmed','Credit','Offline',10000,'2020-11-15','17:12:38',NULL,NULL,NULL);
/*!40000 ALTER TABLE "Payment" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "Products"
--

DROP TABLE IF EXISTS "Products";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Products" (
  "Product_ID" varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Name" varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  "Description" varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  "Price" int(11) DEFAULT NULL,
  "Quantity" int(11) DEFAULT NULL,
  "current_incharge" varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY ("Product_ID"),
  KEY "current_incharge" ("current_incharge"),
  CONSTRAINT "Products_ibfk_1" FOREIGN KEY ("current_incharge") REFERENCES "Employee" ("Employee_ID")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Products"
--

LOCK TABLES "Products" WRITE;
/*!40000 ALTER TABLE "Products" DISABLE KEYS */;
INSERT INTO "Products" VALUES ('Coffee_Nestle','Coffee','Nestle',10,101,'emp_anshul'),('facewash_nivea','facewash','nivea',100,101,'emp_anshul'),('Shampoo_Pantenee shampoo','Shampoo','Pantenee shampoo',100,99,'emp_anshul'),('Soap_dove soap','Soap','dove soap',90,20,'emp_anshul'),('Tissue set_paper napkins','Tissue set','paper napkins',100,100,'emp_anshul'),('Water bottles_Bisleri','Water bottles','Bisleri',10,100,'emp_anshul');
/*!40000 ALTER TABLE "Products" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "Room"
--

DROP TABLE IF EXISTS "Room";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Room" (
  "Room_No" varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  "No_of_Beds" int(11) NOT NULL,
  "Status" varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  "Price" int(11) DEFAULT NULL,
  "Floor_No" int(11) DEFAULT NULL,
  "Air_Conditioned" tinyint(1) DEFAULT NULL,
  "Priviledge_Level" int(11) DEFAULT NULL,
  "Photo_link" varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY ("Room_No")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Room"
--

LOCK TABLES "Room" WRITE;
/*!40000 ALTER TABLE "Room" DISABLE KEYS */;
INSERT INTO "Room" VALUES ('R101',2,'booked',3000,1,0,1,''),('R102',2,'free',3000,1,0,1,''),('R103',2,'booked',3000,1,0,1,''),('R104',2,'free',3000,1,0,1,''),('R105',2,'free',3000,1,0,1,''),('R201',2,'free',5000,1,0,2,''),('R202',2,'free',5000,1,0,2,''),('R203',2,'free',5000,1,0,2,''),('R204',2,'free',5000,1,0,2,''),('R301',3,'free',3000,3,0,1,''),('R302',3,'free',3000,3,0,1,''),('R305',3,'free',3000,3,0,1,'');
/*!40000 ALTER TABLE "Room" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "Room_Service"
--

DROP TABLE IF EXISTS "Room_Service";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Room_Service" (
  "Service_id" varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Status" varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Demands" varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Date" date NOT NULL,
  "Time" time NOT NULL,
  "Employee_ID" varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  "ROOM_ID" varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY ("Service_id"),
  KEY "Employee_ID" ("Employee_ID"),
  KEY "ROOM_ID" ("ROOM_ID"),
  CONSTRAINT "Room_Service_ibfk_1" FOREIGN KEY ("Employee_ID") REFERENCES "Employee" ("Employee_ID"),
  CONSTRAINT "Room_Service_ibfk_2" FOREIGN KEY ("ROOM_ID") REFERENCES "Room" ("Room_No")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Room_Service"
--

LOCK TABLES "Room_Service" WRITE;
/*!40000 ALTER TABLE "Room_Service" DISABLE KEYS */;
INSERT INTO "Room_Service" VALUES ('R10115:36:16','completed','clean my room','2020-11-01','15:36:16','emp_anshul','R101'),('R10118:14:25','completed','clean my room','2020-10-31','18:14:25','emp_anshul','R101'),('R10119:07:07','null','clean my room','2020-10-25','19:07:07',NULL,'R101'),('R10119:07:08','null','clean my room','2020-10-25','19:07:08',NULL,'R101'),('R10119:09:43','null','clean my room','2020-10-25','19:09:43',NULL,'R101'),('R10120:25:09','completed','clean my room','2020-10-25','20:25:09','emp_anshul','R101'),('R10120:32:09','assigned','clean my room','2020-10-25','20:32:09','emp_anshul','R101'),('R10218:12:26','assigned','jiwjdowjd','2020-11-03','18:12:26','emp_anshul','R102'),('R10219:10:04','null','clean my room','2020-10-25','19:10:04',NULL,'R102'),('R10220:32:16','initiated','clean my room','2020-10-25','20:32:16',NULL,'R102');
/*!40000 ALTER TABLE "Room_Service" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "Room_booking"
--

DROP TABLE IF EXISTS "Room_booking";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Room_booking" (
  "count" int(11) NOT NULL,
  "Booking_ID" varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  "priviledge_level" int(11) NOT NULL,
  "start_date" date DEFAULT NULL,
  "end_date" date DEFAULT NULL,
  PRIMARY KEY ("Booking_ID","priviledge_level"),
  KEY "priviledge_level" ("priviledge_level"),
  CONSTRAINT "Room_booking_ibfk_1" FOREIGN KEY ("Booking_ID") REFERENCES "Booking" ("Booking_ID"),
  CONSTRAINT "Room_booking_ibfk_2" FOREIGN KEY ("priviledge_level") REFERENCES "Room_type" ("priviledge_level")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Room_booking"
--

LOCK TABLES "Room_booking" WRITE;
/*!40000 ALTER TABLE "Room_booking" DISABLE KEYS */;
INSERT INTO "Room_booking" VALUES (2,'book_a25e40e12-1f34-47df-b7e4-342591ab2232',1,'2020-09-30','2020-10-14'),(2,'book_a25e40e12-1f34-47df-b7e4-342591ab2232',2,'2020-09-30','2020-10-14'),(2,'book_a26e9850f-4e79-424f-a499-3fcb95484bca',1,'2020-11-11','2020-11-20'),(5,'book_a26e9850f-4e79-424f-a499-3fcb95484bca',2,'2020-11-11','2020-11-20'),(2,'book_a44060a32-f172-4848-b0ea-34e565631e91',1,'2020-11-04','2020-11-21'),(2,'book_a4644cce7-f109-4e02-bdb3-e6e18fa030a8',1,'2020-10-07','2020-10-24'),(2,'book_a4644cce7-f109-4e02-bdb3-e6e18fa030a8',2,'2020-10-07','2020-10-24'),(2,'book_a53565a19-1729-4b99-b5e5-ce764a7ed963',1,'2020-10-07','2020-10-01'),(2,'book_a53565a19-1729-4b99-b5e5-ce764a7ed963',2,'2020-10-07','2020-10-01'),(2,'book_a5fdb5f0c-16d7-419b-8ae9-fb4cd0da6b42',1,'2020-10-07','2020-10-16'),(5,'book_a5fdb5f0c-16d7-419b-8ae9-fb4cd0da6b42',2,'2020-10-07','2020-10-16'),(2,'book_a6dd72414-54e0-4aa1-b38e-e004e920693b',1,'2020-10-07','2020-10-10'),(2,'book_a6dd72414-54e0-4aa1-b38e-e004e920693b',2,'2020-10-07','2020-10-10'),(2,'book_a9eaaec71-6926-480c-97ba-0e8e4d47caaf',1,'2020-09-30','2020-10-23'),(2,'book_a9eaaec71-6926-480c-97ba-0e8e4d47caaf',2,'2020-09-30','2020-10-23'),(2,'book_ab6f01106-732d-4d80-98b3-bca8e9dd0c98',1,'2020-11-11','2020-11-13'),(3,'book_ab6f01106-732d-4d80-98b3-bca8e9dd0c98',2,'2020-11-11','2020-11-13'),(2,'book_ac18000c0-0f4c-4667-a7e2-8c7b77c41669',1,'2020-11-11','2020-11-20'),(4,'book_ac18000c0-0f4c-4667-a7e2-8c7b77c41669',2,'2020-11-11','2020-11-20'),(2,'book_acbf9c1f5-9ecb-4cd3-81b0-1b4d657c4306',2,'2020-10-08','2020-10-23'),(2,'book_ad0ba5e06-6357-43a4-8b24-8be863293b1c',1,'2020-10-07','2020-10-22'),(2,'book_ad0ba5e06-6357-43a4-8b24-8be863293b1c',2,'2020-10-07','2020-10-22'),(2,'book_adfe77ad3-6ce1-47d5-bd19-84997050fd9d',1,'2020-10-14','2020-10-23'),(2,'book_adfe77ad3-6ce1-47d5-bd19-84997050fd9d',2,'2020-10-14','2020-10-23'),(2,'book_af4e8bc6d-2a77-4b8c-bc85-506e76dbc863',2,'2020-10-07','2020-10-08'),(2,'book_afd65b480-11af-4f04-9735-54d7f0e902ef',1,'2020-11-04','2020-11-29');
/*!40000 ALTER TABLE "Room_booking" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "Room_contains"
--

DROP TABLE IF EXISTS "Room_contains";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Room_contains" (
  "Quantity" int(11) NOT NULL,
  "ROOM_ID" varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Product_ID" varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY ("ROOM_ID","Product_ID"),
  KEY "Product_ID" ("Product_ID"),
  CONSTRAINT "Room_contains_ibfk_1" FOREIGN KEY ("ROOM_ID") REFERENCES "Room" ("Room_No"),
  CONSTRAINT "Room_contains_ibfk_2" FOREIGN KEY ("Product_ID") REFERENCES "Products" ("Product_ID")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Room_contains"
--

LOCK TABLES "Room_contains" WRITE;
/*!40000 ALTER TABLE "Room_contains" DISABLE KEYS */;
INSERT INTO "Room_contains" VALUES (1,'R101','Coffee_Nestle'),(1,'R101','facewash_nivea'),(0,'R101','Shampoo_Pantenee shampoo'),(0,'R101','Soap_dove soap'),(0,'R101','Tissue set_paper napkins'),(0,'R101','Water bottles_Bisleri'),(0,'R102','Coffee_Nestle'),(0,'R102','facewash_nivea'),(0,'R102','Shampoo_Pantenee shampoo'),(0,'R102','Soap_dove soap'),(0,'R102','Tissue set_paper napkins'),(0,'R102','Water bottles_Bisleri'),(0,'R103','Coffee_Nestle'),(0,'R103','facewash_nivea'),(0,'R103','Shampoo_Pantenee shampoo'),(0,'R103','Soap_dove soap'),(0,'R103','Tissue set_paper napkins'),(0,'R103','Water bottles_Bisleri'),(0,'R104','Coffee_Nestle'),(0,'R104','facewash_nivea'),(0,'R104','Shampoo_Pantenee shampoo'),(0,'R104','Soap_dove soap'),(0,'R104','Tissue set_paper napkins'),(0,'R104','Water bottles_Bisleri'),(0,'R105','Coffee_Nestle'),(0,'R105','facewash_nivea'),(0,'R105','Shampoo_Pantenee shampoo'),(0,'R105','Soap_dove soap'),(0,'R105','Tissue set_paper napkins'),(0,'R105','Water bottles_Bisleri'),(0,'R201','Coffee_Nestle'),(0,'R201','facewash_nivea'),(0,'R201','Shampoo_Pantenee shampoo'),(0,'R201','Soap_dove soap'),(0,'R201','Tissue set_paper napkins'),(0,'R201','Water bottles_Bisleri'),(0,'R202','Coffee_Nestle'),(0,'R202','facewash_nivea'),(0,'R202','Shampoo_Pantenee shampoo'),(0,'R202','Soap_dove soap'),(0,'R202','Tissue set_paper napkins'),(0,'R202','Water bottles_Bisleri'),(0,'R203','Coffee_Nestle'),(0,'R203','facewash_nivea'),(0,'R203','Shampoo_Pantenee shampoo'),(0,'R203','Soap_dove soap'),(0,'R203','Tissue set_paper napkins'),(0,'R203','Water bottles_Bisleri'),(0,'R204','Coffee_Nestle'),(0,'R204','facewash_nivea'),(0,'R204','Shampoo_Pantenee shampoo'),(0,'R204','Soap_dove soap'),(0,'R204','Tissue set_paper napkins'),(0,'R204','Water bottles_Bisleri'),(0,'R301','Coffee_Nestle'),(0,'R301','facewash_nivea'),(0,'R301','Shampoo_Pantenee shampoo'),(0,'R301','Soap_dove soap'),(0,'R301','Tissue set_paper napkins'),(0,'R301','Water bottles_Bisleri'),(0,'R302','Coffee_Nestle'),(0,'R302','facewash_nivea'),(0,'R302','Shampoo_Pantenee shampoo'),(0,'R302','Soap_dove soap'),(0,'R302','Tissue set_paper napkins'),(0,'R302','Water bottles_Bisleri'),(0,'R305','Coffee_Nestle'),(0,'R305','facewash_nivea'),(0,'R305','Shampoo_Pantenee shampoo'),(0,'R305','Soap_dove soap'),(0,'R305','Tissue set_paper napkins'),(0,'R305','Water bottles_Bisleri');
/*!40000 ALTER TABLE "Room_contains" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "Room_type"
--

DROP TABLE IF EXISTS "Room_type";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "Room_type" (
  "priviledge_level" int(11) NOT NULL,
  "Total_count" int(11) DEFAULT NULL,
  "price" int(11) DEFAULT NULL,
  "ac" tinyint(1) DEFAULT NULL,
  "photo_url" varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY ("priviledge_level")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "Room_type"
--

LOCK TABLES "Room_type" WRITE;
/*!40000 ALTER TABLE "Room_type" DISABLE KEYS */;
INSERT INTO "Room_type" VALUES (1,10,3000,0,''),(2,10,5000,1,''),(3,5,6000,1,'');
/*!40000 ALTER TABLE "Room_type" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "User"
--

DROP TABLE IF EXISTS "User";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "User" (
  "username" varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  "password" varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  "role" varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY ("username")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "User"
--

LOCK TABLES "User" WRITE;
/*!40000 ALTER TABLE "User" DISABLE KEYS */;
INSERT INTO "User" VALUES ('a','$2a$10$4fNyX7DlcVIlx428Zstqj.FMlSsO9GJkXCFR7FbFXmOSztFkWxc3S','customer'),('a1','$2a$10$xP9n10WhRB5ITi02CeFnk.BnIEtJW3/JzNPdfwbwLdhdJinZgnr4S','customer'),('a12','$2a$10$cHThAzlKSKZIeFnHIm.2VObfwiN4yTqt9tmd1.8tC8gSJKRL.9b4S','customer'),('a122','$2a$10$thkZ91HTLSvzFNyqFjLftuQBheJI40AmkZfoKHFzRVc6uin8pR9VS','customer'),('a1222','$2a$10$BDLsQBlpRuojCsx6M04CkeOSeiGyr0v/f3832HhbgsisVDAiayWaS','customer'),('a123','$2a$10$s0wW3YfZgd3SOgaB5ZIEuusCIgF0pv3O6KvW0TNm8NKyb5KDj88ZW','customer'),('ampa','$2a$10$DCooIOGsaxx2bwL8v70zNeQdJ19x6kx58.MAZCtqJeogfs0erM.ye','customer'),('anshul','$2a$10$Eketamoi.t9W9naXzd3NPeKznOcDHjcHu/4Lk5bDf6ej8y/QYXIb6','customer'),('ar','$2a$10$2BTmAMGSEAMHAvhAnUCni.S5YrzmtI6PpK0KO987Kda4w2oLi1/iK','customer'),('arpit','mehta','customer'),('arpitmehta','$2a$10$yaoxDYc/TLZTQGF66qg5Ze1Uf49q82gs4biJrbau.DxnII.Utp65e','admin'),('ccd','$2a$10$bbkO5fpegyqZktCN558lS./ZcL9Ps.IYUDw2wH2SVNQFHPt2Jj5tO','customer'),('customer','$2a$10$yaoxDYc/TLZTQGF66qg5Ze1Uf49q82gs4biJrbau.DxnII.Utp65e','customer'),('emp_anshul','$2a$10$H56ZNhtolejNKLLCTjAO0u8zL9c18v3Ba5IYMbArBFjQSzBQ5jR6m','employee'),('emp_anshul_1','$2a$10$3CtQjNmuk6iVrKQfZ3tVh.QqQ6mJj8hftI4hQO4zQIA7Znx/Bfcz.','employee'),('gavo1','$2a$10$DbX1VKyFSMdIeR8YLm.puul3JeyFInkdbaDaqtl2A5FD4zAfsUZEe','customer'),('gavow3','$2a$10$yL2ixTVFcMulkPlxu9ewV.a17uHparlKK/6qhMLIgUArHY4W0ZLMC','customer'),('wee','$2a$10$PKuL/ElLV/2Bi7MDS7uekO1LbsztCCfHT57f0cKxfKHcXBILjm0h.','customer');
/*!40000 ALTER TABLE "User" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "_Salaries_made"
--

DROP TABLE IF EXISTS "_Salaries_made";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "_Salaries_made" (
  "payment_ID" varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  "Employee_ID" varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY ("payment_ID","Employee_ID"),
  KEY "Employee_ID" ("Employee_ID"),
  CONSTRAINT "_Salaries_made_ibfk_1" FOREIGN KEY ("payment_ID") REFERENCES "Payment" ("payment_ID"),
  CONSTRAINT "_Salaries_made_ibfk_2" FOREIGN KEY ("Employee_ID") REFERENCES "Employee" ("Employee_ID")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "_Salaries_made"
--

LOCK TABLES "_Salaries_made" WRITE;
/*!40000 ALTER TABLE "_Salaries_made" DISABLE KEYS */;
INSERT INTO "_Salaries_made" VALUES ('emp_anshul_17:12:38','emp_anshul');
/*!40000 ALTER TABLE "_Salaries_made" ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table "books"
--

DROP TABLE IF EXISTS "books";
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE "books" (
  "Booking_ID" varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  "ROOM_ID" varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY ("Booking_ID","ROOM_ID"),
  KEY "ROOM_ID" ("ROOM_ID"),
  CONSTRAINT "books_ibfk_1" FOREIGN KEY ("Booking_ID") REFERENCES "Booking" ("Booking_ID"),
  CONSTRAINT "books_ibfk_2" FOREIGN KEY ("ROOM_ID") REFERENCES "Room" ("Room_No")
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table "books"
--

LOCK TABLES "books" WRITE;
/*!40000 ALTER TABLE "books" DISABLE KEYS */;
INSERT INTO "books" VALUES ('book_a26e9850f-4e79-424f-a499-3fcb95484bca','R103'),('book_a53565a19-1729-4b99-b5e5-ce764a7ed963','R101');
/*!40000 ALTER TABLE "books" ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-16 21:49:04
