-- phpMyAdmin SQL Dump
-- version 4.4.3
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 07, 2015 at 04:04 PM
-- Server version: 5.6.24
-- PHP Version: 5.5.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `mmuboard`
--

-- --------------------------------------------------------

--
-- Table structure for table `nsa`
--

CREATE TABLE IF NOT EXISTS `nsa` (
  `id` int(11) NOT NULL,
  `logged_in_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

CREATE TABLE IF NOT EXISTS `post` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `topic_id` int(11) NOT NULL,
  `title` int(30) NOT NULL,
  `description` varchar(60) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE IF NOT EXISTS `subject` (
  `id` int(11) NOT NULL,
  `name` varchar(40) NOT NULL,
  `description` varchar(60) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`id`, `name`, `description`, `created_at`, `updated_at`) VALUES
(1, 'OOAD', 'Object Oriented Programming', '2015-08-29 09:17:11', '0000-00-00 00:00:00'),
(2, 'OS', 'Operating System', '2015-08-29 09:18:37', '0000-00-00 00:00:00'),
(3, 'CN', 'Computer Network', '2015-08-29 09:18:49', '0000-00-00 00:00:00'),
(4, 'RM', 'Research Methodlogy', '2015-08-29 09:19:12', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `topic`
--

CREATE TABLE IF NOT EXISTS `topic` (
  `id` int(11) NOT NULL,
  `title` varchar(30) NOT NULL,
  `description` varchar(60) NOT NULL,
  `user_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `topic`
--

INSERT INTO `topic` (`id`, `title`, `description`, `user_id`, `subject_id`, `created_at`, `updated_at`) VALUES
(5, 'JSP or Java App??', '', 1, 1, '2015-08-30 07:15:27', '0000-00-00 00:00:00'),
(6, 'Ng Hu is awesome', '', 1, 2, '2015-08-30 07:35:52', '0000-00-00 00:00:00'),
(7, 'Tips for Midterm', '', 1, 2, '2015-08-30 07:16:16', '0000-00-00 00:00:00'),
(8, 'Hello', 'Wtf', 1, 1, '2015-08-30 09:17:33', '0000-00-00 00:00:00'),
(9, 'Hi', '', 1, 1, '2015-08-30 09:23:01', '0000-00-00 00:00:00'),
(10, 'Computer Network', '', 1, 3, '2015-08-30 09:25:18', '0000-00-00 00:00:00'),
(11, 'success', '', 1, 1, '2015-08-30 09:35:58', '0000-00-00 00:00:00'),
(12, 'hello', '', 1, 3, '2015-08-30 09:38:45', '0000-00-00 00:00:00'),
(13, '123', '', 1, 1, '2015-08-30 09:39:45', '0000-00-00 00:00:00'),
(14, '123', '', 1, 3, '2015-08-30 09:39:52', '0000-00-00 00:00:00'),
(15, '123', '', 1, 1, '2015-08-30 09:42:48', '0000-00-00 00:00:00'),
(16, '123', '', 1, 1, '2015-08-30 09:43:53', '0000-00-00 00:00:00'),
(17, '123', '', 1, 1, '2015-08-30 09:47:50', '0000-00-00 00:00:00'),
(18, '321', '', 1, 1, '2015-08-30 09:48:26', '0000-00-00 00:00:00'),
(19, 'a', '', 1, 1, '2015-08-30 09:48:55', '0000-00-00 00:00:00'),
(20, 'b', '', 1, 1, '2015-08-30 09:51:25', '0000-00-00 00:00:00'),
(21, 'dasd', '', 1, 1, '2015-08-30 09:54:44', '0000-00-00 00:00:00'),
(22, '123', '', 1, 1, '2015-08-30 09:54:51', '0000-00-00 00:00:00'),
(23, '321', '', 1, 1, '2015-08-30 09:57:59', '0000-00-00 00:00:00'),
(24, '222', '', 1, 1, '2015-08-30 10:06:40', '0000-00-00 00:00:00'),
(25, '321', '', 1, 1, '2015-08-30 10:08:43', '0000-00-00 00:00:00'),
(26, '123', '', 1, 4, '2015-08-30 10:09:56', '0000-00-00 00:00:00'),
(27, '321', '123', 1, 1, '2015-08-30 10:16:50', '0000-00-00 00:00:00'),
(28, '123', '123', 1, 3, '2015-08-30 10:18:08', '0000-00-00 00:00:00'),
(29, '123', '123', 1, 2, '2015-08-30 10:19:53', '0000-00-00 00:00:00'),
(30, '123', '', 1, 1, '2015-08-30 10:24:17', '0000-00-00 00:00:00'),
(31, 'asd', 'asd', 1, 1, '2015-09-01 02:45:48', '0000-00-00 00:00:00'),
(32, 'wtf', 'wtf', 1, 1, '2015-09-01 02:45:55', '0000-00-00 00:00:00'),
(33, 'Noo', '', 1, 2, '2015-09-01 03:22:23', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `name` varchar(40) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `email` varchar(60) NOT NULL,
  `user_type` varchar(10) NOT NULL DEFAULT 'student',
  `login_count` int(4) NOT NULL DEFAULT '0',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `username`, `password`, `email`, `user_type`, `login_count`, `updated_at`, `created_at`) VALUES
(1, 'Jack', 'admin', 'admin', 'jackgoh0@gmail.com', 'student', 1, '2015-08-29 07:23:18', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `vote`
--

CREATE TABLE IF NOT EXISTS `vote` (
  `id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `nsa`
--
ALTER TABLE `nsa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `topic`
--
ALTER TABLE `topic`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vote`
--
ALTER TABLE `vote`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `nsa`
--
ALTER TABLE `nsa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `post`
--
ALTER TABLE `post`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `topic`
--
ALTER TABLE `topic`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=34;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `vote`
--
ALTER TABLE `vote`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
