CREATE DATABASE QUAN_LY_SACH_NHOM8
use QUAN_LY_SACH_NHOM8
CREATE TABLE SACH(
	MaSach varchar(10) not null PRIMARY KEY,
	TenSach nvarchar(50) not null,
	TenTacGia nvarchar(50) not null,
	LoaiSach nvarchar(30) not null,
	SoLuong int not null,
	NamXuatBan int not null,
	GiaSach float not null
);

create table ACCOUNT(
	usename varchar(50) primary key not null,
	pass varchar(50) not null,
	confirm varchar(50) not null,
)
drop table HoaDon
create table HoaDon(
	MaHoaDon int identity(1,1) primary key not null,
	MaSach varchar(10) not null,
	TenSach nvarchar(50) not null,
	Soluongmua int not null,
	DiaChi nvarchar(50) not null,
	SDT varchar(12) not null,
	ThanhTien money,
	foreign key(MaSach) references SACH(MaSach)
)
create table HoaDonChiTiet(
	usename varchar(50) not null,
	MaSach varchar(10) not null,
	SoLuongMua int not null,

)

SELECT hd.MaHoaDon,s.MaSach,s.TenSach,hd.Soluongmua,hd.DiaChi,hd.SDT,(hd.Soluongmua * s.GiaSach) as ThanhTien FROM HoaDon hd join SACH s on s.MaSach = hd.MaSach
