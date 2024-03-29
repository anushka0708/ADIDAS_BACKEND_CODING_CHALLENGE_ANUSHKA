-- Dumping database structure for adidas
CREATE DATABASE IF NOT EXISTS `adidas` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `adidas`;

-- Dumping structure for table adidas.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT 'NA',
  `model_number` varchar(200) DEFAULT 'NA',
  `product_type` varchar(50) DEFAULT 'NA',
  `standard_price` float DEFAULT '0',
  `standard_price_no_vat` float DEFAULT '0',
  `currentPrice` float DEFAULT '0',
  `page_title` varchar(250) DEFAULT "NA",
  `title` varchar(250) DEFAULT "NA",
  `subtitle` varchar(250) DEFAULT "NA",
  `text` longtext,
  `site_name` varchar(250) DEFAULT "NA",
  `description` longtext,
  `canonical` varchar(250) DEFAULT "NA",
  `keywords` varchar(250) DEFAULT "NA",
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table adidas.product:
INSERT INTO `product` (`id`, `name`, `model_number`, `product_type`, `standard_price`, `standard_price_no_vat`, `currentPrice`, `page_title`, `title`, `subtitle`, `text`, `site_name`, `description`, `canonical`, `keywords`) VALUES('HGTT199', 'Nite Jogger Shoes', 'BTO93', 'inline', 119.95, 99.96, 119.95, 'adidas Nite Jogger Shoes - Black | adidas UK', 'hey there', 'Modern cushioning updates this flashy \'80s standout.', 'Inspired by the 1980 Nite Jogger, these shoes shine bright with retro style and ', 'adidas United Kingdom', 'Shop for Nite Jogger Shoes - Black at adidas.co.uk! See all the styles ', 'Nite Jogger Shoes', '//www.adidas.co.uk/nite-jogger-shoes/CG7088.html');
