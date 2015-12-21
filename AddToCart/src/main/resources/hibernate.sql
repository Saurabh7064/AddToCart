/*
SQLyog - Free MySQL GUI v5.02
Host - 5.5.27 : Database - addtocart
*********************************************************************
Server version : 5.5.27
*/


create database if not exists `addtocart`;

USE `addtocart`;

/*Table structure for table `cart` */

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Data for the table `cart` */

insert into `cart` values 
(4,'saurabh'),
(5,'zayed'),
(6,'armaan'), 