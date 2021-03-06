USE [master]
GO
/****** Object:  Database [MIMS]    Script Date: 2016/6/19 13:59:40 ******/
CREATE DATABASE [MIMS]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'MIMS', FILENAME = N'D:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\MIMS.mdf' , SIZE = 4160KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'MIMS_log', FILENAME = N'D:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\MIMS_log.ldf' , SIZE = 1040KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [MIMS] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [MIMS].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [MIMS] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [MIMS] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [MIMS] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [MIMS] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [MIMS] SET ARITHABORT OFF 
GO
ALTER DATABASE [MIMS] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [MIMS] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [MIMS] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [MIMS] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [MIMS] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [MIMS] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [MIMS] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [MIMS] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [MIMS] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [MIMS] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [MIMS] SET  ENABLE_BROKER 
GO
ALTER DATABASE [MIMS] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [MIMS] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [MIMS] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [MIMS] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [MIMS] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [MIMS] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [MIMS] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [MIMS] SET RECOVERY FULL 
GO
ALTER DATABASE [MIMS] SET  MULTI_USER 
GO
ALTER DATABASE [MIMS] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [MIMS] SET DB_CHAINING OFF 
GO
ALTER DATABASE [MIMS] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [MIMS] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'MIMS', N'ON'
GO
USE [MIMS]
GO
/****** Object:  Table [dbo].[Course]    Script Date: 2016/6/19 13:59:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Course](
	[Cno] [int] NULL,
	[Cname] [varchar](50) NULL,
	[Cpno] [nchar](10) NULL,
	[Credit] [nchar](10) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SC]    Script Date: 2016/6/19 13:59:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SC](
	[Sno] [int] NULL,
	[Cno] [int] NULL,
	[Cgrade] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[stu]    Script Date: 2016/6/19 13:59:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[stu](
	[stuid] [varchar](30) NOT NULL,
	[stuname] [nvarchar](50) NOT NULL,
	[stusex] [nchar](1) NULL,
	[stuage] [int] NULL,
	[stujg] [nvarchar](30) NULL,
	[studept] [nvarchar](40) NULL,
PRIMARY KEY CLUSTERED 
(
	[stuid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Course] ([Cno], [Cname], [Cpno], [Credit]) VALUES (1, N'数据', N'5         ', N'4         ')
INSERT [dbo].[Course] ([Cno], [Cname], [Cpno], [Credit]) VALUES (2, N'数学', N'          ', N'2         ')
INSERT [dbo].[Course] ([Cno], [Cname], [Cpno], [Credit]) VALUES (3, N'信息系统', N'2         ', N'4         ')
INSERT [dbo].[Course] ([Cno], [Cname], [Cpno], [Credit]) VALUES (4, N'操作系统', N'6         ', N'3         ')
INSERT [dbo].[Course] ([Cno], [Cname], [Cpno], [Credit]) VALUES (5, N'数据结构', N'7         ', N'4         ')
INSERT [dbo].[Course] ([Cno], [Cname], [Cpno], [Credit]) VALUES (6, N'数据处理', N'3         ', N'2         ')
INSERT [dbo].[Course] ([Cno], [Cname], [Cpno], [Credit]) VALUES (7, N'PASCAL', N'6         ', N'4         ')
INSERT [dbo].[SC] ([Sno], [Cno], [Cgrade]) VALUES (1611101, 1, 78)
INSERT [dbo].[SC] ([Sno], [Cno], [Cgrade]) VALUES (1611102, 2, 80)
INSERT [dbo].[SC] ([Sno], [Cno], [Cgrade]) VALUES (1611103, 1, 79)
INSERT [dbo].[SC] ([Sno], [Cno], [Cgrade]) VALUES (1611104, 3, 85)
INSERT [dbo].[SC] ([Sno], [Cno], [Cgrade]) VALUES (1611105, 5, 70)
INSERT [dbo].[SC] ([Sno], [Cno], [Cgrade]) VALUES (1611106, 4, 90)
INSERT [dbo].[SC] ([Sno], [Cno], [Cgrade]) VALUES (1611107, 2, 100)
INSERT [dbo].[stu] ([stuid], [stuname], [stusex], [stuage], [stujg], [studept]) VALUES (N'1611101', N'吴琳', N'女', 19, N'上海', N'化学系')
INSERT [dbo].[stu] ([stuid], [stuname], [stusex], [stuage], [stujg], [studept]) VALUES (N'1611102', N'李莉', N'女', 20, N'广东', N'数学系')
INSERT [dbo].[stu] ([stuid], [stuname], [stusex], [stuage], [stujg], [studept]) VALUES (N'1611103', N'李亮', N'男', 20, N'湖北', N'计算机')
INSERT [dbo].[stu] ([stuid], [stuname], [stusex], [stuage], [stujg], [studept]) VALUES (N'1611104', N'赵玲', N'女', 20, N'西安', N'文学系')
INSERT [dbo].[stu] ([stuid], [stuname], [stusex], [stuage], [stujg], [studept]) VALUES (N'1611105', N'刘晨', N'男', 21, N'天津', N'计算机')
INSERT [dbo].[stu] ([stuid], [stuname], [stusex], [stuage], [stujg], [studept]) VALUES (N'1611106', N'王萌萌', N'女', 19, N'广东', N'计算机系')
INSERT [dbo].[stu] ([stuid], [stuname], [stusex], [stuage], [stujg], [studept]) VALUES (N'1611107', N'胡力军', N'男', 19, N'广西', N'化学系')
INSERT [dbo].[stu] ([stuid], [stuname], [stusex], [stuage], [stujg], [studept]) VALUES (N'1611108', N'周天航', N'男', 21, N'北京', N'计算机系')
INSERT [dbo].[stu] ([stuid], [stuname], [stusex], [stuage], [stujg], [studept]) VALUES (N'1611109', N'黄雅琪', N'女', 21, N'上海', N'生物系')
INSERT [dbo].[stu] ([stuid], [stuname], [stusex], [stuage], [stujg], [studept]) VALUES (N'1611110', N'沈浩', N'男', 20, N'广东', N'计算机系')
ALTER TABLE [dbo].[stu] ADD  DEFAULT ('男') FOR [stusex]
GO
ALTER TABLE [dbo].[stu]  WITH CHECK ADD CHECK  (([stuage]>(1)))
GO
ALTER TABLE [dbo].[stu]  WITH CHECK ADD CHECK  (([stusex]='女' OR [stusex]='男'))
GO
USE [master]
GO
ALTER DATABASE [MIMS] SET  READ_WRITE 
GO
