--use master

--drop database QLBHSPORT
--go
--create database QLBHSPORT
--go
use QLBHSPORT
go

--them du lieu xuatxu
insert into XuatXu values ('XX0001', N'Việt Nam')
insert into XuatXu values ('XX0002', N'Trung Quốc')
insert into XuatXu values ('XX0003', N'Hàn Quốc')
insert into XuatXu values ('XX0004', N'Đức')
insert into XuatXu values ('XX0005', N'Nhật Bản')
insert into XuatXu values ('XX0006', N'Đài Loan')

--them du lieu phan loai
insert into PhanLoai values ('PL0001', N'Máy chạy bộ');
insert into PhanLoai values ('PL0002', N'Ghế tập tạ');
insert into PhanLoai values ('PL0003', N'Tạ tay');
insert into PhanLoai values ('PL0004', N'Vợt bóng bàn');
insert into PhanLoai values ('PL0005', N'Dây nhảy thể dục');
insert into PhanLoai values ('PL0006', N'Xà');
insert into PhanLoai values ('PL0007', N'Thảm yoga');
insert into PhanLoai values ('PL0008', N'Dây đàn hồi');
insert into PhanLoai values ('PL0009', N'Xe đạp thể dục');

--them du lieu chat lieu
insert into ChatLieu values ('CL0001', N'Sắt')
insert into ChatLieu values ('CL0002', N'Cao su')
insert into ChatLieu values ('CL0003', N'Thép')
insert into ChatLieu values ('CL0004', N'Nhựa')
insert into ChatLieu values ('CL0005', N'Gỗ')
insert into ChatLieu values ('CL0006', N'PVC')
insert into ChatLieu values ('CL0007', N'Vải')
insert into ChatLieu values ('CL0008', N'Cáp')

--them du lieu mau sac
insert into MauSac values ('MS0001', N'Trắng');
insert into MauSac values ('MS0002', N'Đen');
insert into MauSac values ('MS0003', N'Nâu');
insert into MauSac values ('MS0004', N'Xanh Trắng');
insert into MauSac values ('MS0005', N'Đỏ');
insert into MauSac values ('MS0006', N'Đỏ đen');
insert into MauSac values ('MS0007', N'Xanh lá cây');
insert into MauSac values ('MS0008', N'Cam');
insert into MauSac values ('MS0009', N'Xanh da trời');
insert into MauSac values ('MS0010', N'Trắng đen');
insert into MauSac values ('MS0011', N'Trắng xám');
insert into MauSac values ('MS0012', N'Đen xám');
insert into MauSac values ('MS0013', N'Đen vàng');
insert into MauSac values ('MS0014', N'Không sơn');

----Them gia tri vao table nha cung cap
insert into NhaCungCap([maNCC],[tenNCC],[diaChi],[email],[sDT]) values ('NCC001',N'Công Ty TNHH Thể Thao Thiên Trường',N'4323 Trần Văn Kiểu, Phường 11, Quận 6, TP. Hồ Chí Minh',       'info@thethaothientruong.vn','0949792525')
insert into NhaCungCap([maNCC],[tenNCC],[diaChi],[email],[sDT]) values ('NCC002',N'Công Ty TNHH Hồng Gia Phát',        N'Số 10, Ngõ 198 Xã Đàn, Đống Đa,Hà Nội',                        'sportonline.vn@gmail.com',  '0912633363')
insert into NhaCungCap([maNCC],[tenNCC],[diaChi],[email],[sDT]) values ('NCC003',N'Công Ty TNHH Hồng Gia Phát',        N'180/35 Lý Thánh Tông, P. Hiệp Tân, Q. Tân Phú,Tp. Hồ Chí Minh','ctygiaphat@gmail.com',      '02837513353')
insert into NhaCungCap([maNCC],[tenNCC],[diaChi],[email],[sDT]) values ('NCC004',N'Công Ty TNHH Thể Thao Minh Toàn',   N'Số 14, ngõ 185 Đặng Tiến Đông, Đống Đa,Hà Nội',                'thethaominhtoan@gmail.com', '0946169876')
insert into NhaCungCap([maNCC],[tenNCC],[diaChi],[email],[sDT]) values ('NCC005',N'Công Ty Cổ Phần Thể Thao Đại Việt', N'32A Ngõ 124/22, Âu Cơ, Tây Hồ,Hà Nội',                         'nhanh24h@gmail.com',        '02466836247')


--them du lieu san pham
--may chay bo
insert into sanPham values ('SP0001',16500000, 'maychaybo1.png', N'Máy chạy bộ điện ORENI-RE3', 5,N'Máy chạy bộ điện ORENI-RE3', 'CL0003', 'MS0002','NCC001','PL0001','XX0001')
insert into sanPham values ('SP0002',24500000, 'maychaybo2.png', N'Máy chạy bộ điện ORENI-RE7', 5,N'Máy chạy bộ điện ORENI-RE7', 'CL0003', 'MS0011','NCC002','PL0001','XX0001')
insert into sanPham values ('SP0003',23500000, 'maychaybo3.png',    N'Máy chạy bộ điện HQ-777', 5,N'Máy chạy bộ điện HQ-777', 'CL0003', 'MS0002','NCC001','PL0001','XX0001')
insert into sanPham values ('SP0004',13950000, 'maychaybo4.png',    N'Máy chạy bộ điện HQ-V1C', 5,N'Máy chạy bộ điện HQ-V1C', 'CL0003', 'MS0010','NCC001','PL0001','XX0001')
insert into sanPham values ('SP0005',13950000, 'maychaybo5.png',N'Máy chạy bộ điện SAKURA-S33', 5,N'Máy chạy bộ điện SAKURA-S33', 'CL0003', 'MS0010','NCC001','PL0001','XX0006')

--ghe tap ta
insert into sanPham values ('SP0006',6985000, 'ghetapta1.png', N'Ghế tập tạ GM-4380',  5,N'Ghế tập tạ GM-4380',  'CL0003', 'MS0002', 'NCC005','PL0002', 'XX0002')
insert into sanPham values ('SP0007',3795000, 'ghetapta2.png', N'Ghế tập tậ T058',     5,N'Ghế tập tạ T058',     'CL0003', 'MS0002','NCC005', 'PL0002', 'XX0002')
insert into sanPham values ('SP0008',4345000, 'ghetapta3.png', N'Ghế tập tạ NMS-7301', 5,N'Ghế tập tạ NMS-7301', 'CL0003', 'MS0002','NCC005', 'PL0002', 'XX0002')
insert into sanPham values ('SP0009',3690000, 'ghetapta4.png', N'Ghế tập tạ ALAS-770D',5,N'Ghế tập tạ ALAS-770D','CL0003', 'MS0013','NCC005', 'PL0002', 'XX0002')
insert into sanPham values ('SP0010',3850000, 'ghetapta5.png', N'Ghế tập tạ XK-2022',  5,N'Ghế tập tạ XK-2022',  'CL0003', 'MS0002','NCC005', 'PL0002', 'XX0002')

--ta tay
insert into sanPham values ('SP0011',3980000, 'tatay1.png', N'Tạ tay điều chỉnh 20KG',               5,N'Tạ tay điều chỉnh 20KG',               'CL0003','MS0002','NCC001','PL0003','XX0001')
insert into sanPham values ('SP0012',2890000, 'tatay2.png', N'Tạ tay điều chỉnh 11.5 KG',            5,N'Tạ tay điều chỉnh 11.5 KG',            'CL0003','MS0002','NCC001','PL0003','XX0001')
insert into sanPham values ('SP0013',5350000, 'tatay3.png', N'Tạ tay BOWFLEX-552 24KG',              5,N'Tạ tay BOWFLEX-552 24KG',              'CL0003','MS0002','NCC001','PL0003','XX0002')
insert into sanPham values ('SP0014',7800000, 'tatay4.png', N'Tạ tay điều chỉnh BOWFLEX-1090 40.8KG',5,N'Tạ tay điều chỉnh BOWFLEX-1090 40.8KG','CL0003','MS0002','NCC001','PL0003','XX0002')
insert into sanPham values ('SP0015',1850000, 'tatay5.png', N'Tạ tay đa năng FED 15KG',              5,N'Tạ tay đa năng FED 15KG',              'CL0003','MS0013','NCC001','PL0003','XX0002')

--vot bong ban
insert into sanPham values ('SP0016',1700000,'treiberk.png',         N'Vợt bóng bàn Andro Treiber K',     10, N'Vợt bóng bàn Andro Treiber K',     'CL0005','MS0014','NCC002','PL0004','XX0004')
insert into sanPham values ('SP0017',300000,' goldenmax2.png',       N'Vợt bóng bàn 729 Golden Max 2Star',10, N'Vợt bóng bàn 729 Golden Max 2Star','CL0005','MS0014','NCC002','PL0004','XX0002')
insert into sanPham values ('SP0018',2600000,'xiomfeelhxpro.png',    N'Vợt bóng bàn Xiom Feel HX PRO',    10, N'Vọt bóng bàn Xiom Feel HX PRO',    'CL0005','MS0014','NCC003','PL0004','XX0005')
insert into sanPham values ('SP0019',1500000,'butterflyskcarbon.png',N'Vợt bóng bàn Butterfly SK Carbon', 10, N'Vợt bóng bàn Butterfly SK Carbon', 'CL0005','MS0014','NCC003','PL0004','XX0005')
insert into sanPham values ('SP0020',1400000,'stigaclipper.png',     N'Vợt bóng bàn Stiga Clipper',       10, N'Vợt bóng bàn Stiga Clipper',       'CL0005','MS0014','NCC003','PL0004','XX0002')

--day nhay the duc
insert into sanPham values ('SP0021',150000,'kangruikb805.png', N'Dây nhảy thể dục Kangrui KB805', 10, N'Dây nhảy thể dục Kangrui KB805','CL0006','MS0006','NCC003','PL0005','XX0002')
insert into sanPham values ('SP0022',611000,'reebok40082.png',  N'Dây nhảy thể dục Reebok 40082',  10, N'Dây nhảy thể dục Reebok 40082', 'CL0006','MS0009','NCC003','PL0005','XX0006')
insert into sanPham values ('SP0023',599000,'adidasad11011.png',N'Dây nhảy thể dục Adidas AD11011',10, N'Dây nhảy thể dục Adidas 11011', 'CL0006','MS0002','NCC003','PL0005','XX0004')
insert into sanPham values ('SP0024',95000, 'w0526.png',        N'Dây nhảy thể dục W0526',         10, N'Dây nhảy thể dục W0526',        'CL0006','MS0002','NCC003','PL0005','XX0002')
insert into sanPham values ('SP0025',165000,'w288.png',         N'Dây nhảy thể dục W288',          10, N'Dây nhảy thể dục W288',         'CL0006','MS0008','NCC003','PL0005','XX0002')

--xa
insert into sanPham values ('SP0026',960000, 'mk4007.png',N'Xà đa năng MK4007',   5,N'Xà đa năng MK4007',   'CL0003','MS0002','NCC004','PL0006','XX0002')
insert into sanPham values ('SP0027',1850000,'tt2020.png',N'Xà xếp TT-2020',      5,N'Xà xếp TT-2020',      'CL0003','MS0001','NCC004','PL0006','XX0001')
insert into sanPham values ('SP0028',3130000,'t056.png',  N'Xà đa năng T056',     5,N'Xà đa năng T056',     'CL0003','MS0002','NCC004','PL0006','XX0002')
insert into sanPham values ('SP0029',3235000,'tt2021.png',N'Xà Thiên Trường 2021',5,N'Xà Thiên Trường 2021','CL0003','MS0006','NCC004','PL0006','XX0001')
insert into sanPham values ('SP0030',1199000,'hm911.png', N'Xà kép đa năng HM911',5,N'Xà kép đa năng HM911','CL0003','MS0002','NCC004','PL0006','XX0002')

--tham yoga
insert into sanPham values ('SP0031',1920000,'adidas10820vc.png',     N'Thảm Yoga Adidas 10820VC',    10,N'Thảm Yoga Adidas 10820VC',    'CL0007','MS0003','NCC004','PL0007','XX0004')
insert into sanPham values ('SP0032',1350000,'adidasadmt12235.png',   N'Thảm Yoga Adias ADMT12235',   10,N'Thảm Yoga Adidas ADMT12235',  'CL0007','MS0006','NCC004','PL0007','XX0004')
insert into sanPham values ('SP0033',839000,' adidasadmnt11015bl.png',N'Thảm Yoga Adidas ADMT11015BL',10,N'Thảm Yoga Adidas ADMT11015BL','CL0007','MS0009','NCC004','PL0007','XX0004')
insert into sanPham values ('SP0034',1789000,'adidasadmt13232gr.png', N'Thảm Yoga Adidas ADMT13232GR',10,N'Thảm Yoga Adidas ADMT13232GR','CL0007','MS0011','NCC004','PL0007','XX0006')
insert into sanPham values ('SP0035',769000, 'adidasadyg10100bl.png', N'Thảm Yoga Adidas ADYG10100BL',10,N'Thảm Yoga Adidas ADYG10100Bl','CL0007','MS0012','NCC004','PL0007','XX0002')

--day dan hoi
insert into sanPham values ('SP0036',623000, 'adtb10601.png',      N'Dây đàn hồi Adidas ADTB10601',10, N'Dây đàn hồi Adidas ADTB10601', 'CL0002','MS0006','NCC005','PL0008','XX0006')
insert into sanPham values ('SP0037',373000, 'reebokre11032bk.png',N'Dây đàn hồi Reebok RE11032BK',10, N'Dây đàn hồi Reebok RE11032Bk', 'CL0002','MS0002','NCC005','PL0008','XX0006')
insert into sanPham values ('SP0038',1015000,'reebokbatb11034.png',N'Dây đàn hồi Reebok BATB11034',10, N'Dây đàn hồi Reebok BATB11034', 'CL0002','MS0013','NCC005','PL0008','XX0006')
insert into sanPham values ('SP0039',341000, 'reebokr2.png',       N'Dây đàn hồi Reebok R2',       10, N'Dây đàn hồi R2',               'CL0002','MS0002','NCC005','PL0008','XX0006')
insert into sanPham values ('SP0040',691000, 'adtb10603.png',      N'Dây đàn hồi Adidas ADTB10603',10, N'Dây đàn hồi Adidas ADTB10603', 'CL0002','MS0006','NCC005','PL0008','XX0006')

--xe dap the duc
insert into sanPham values ('SP0041',3850000, 'sovnial003.png',  N'Xe đạp thể dục SOVNIA L003',  5, N'Xe đạp thể dục SOVNIA L003',  'CL0003','MS0002','NCC005','PL0009','XX0002')
insert into sanPham values ('SP0042',8990000, 'orenire111.png',  N'Xe đạp thể dục Oreni RE111',  5, N'Xe đạp thể dục Oreni RE111',  'CL0003','MS0001','NCC005','PL0009','XX0002')
insert into sanPham values ('SP0043',36000000,'impulsere500.png',N'Xe đạp thể dục IMPULSE RE500',5, N'Xe đập thể dục IMPULSE RE500','CL0003','MS0002','NCC005','PL0009','XX0005')
insert into sanPham values ('SP0044',9900000, 'ps250.png',       N'Xe đạp thể dục TOKADO PS250', 5, N'Xe đạp thể dục TOKADO PS250', 'CL0003','MS0002','NCC005','PL0009','XX0005')
insert into sanPham values ('SP0045',11500000,'tk2000.png',      N'Xe đạp thể dục TOKADO TK2000',5, N'Xe đạp thể dục TOKADO TK2000','CL0003','MS0002','NCC005','PL0009','XX0005')

--them du lieu khach hang
insert into khachHang values ('KH0001','hvlt@gmail.com',              1, N'Lê Thị Hồng Vương', '0337098734')
insert into khachHang values ('KH0002','duongngoc@gmail.com',         0, N'Bùi Ngọc Dương',    '0914712039')
insert into khachHang values ('KH0003','tuong98@gmail.com',           0, N'Dinh Huy Tường',    '0961410277')
insert into khachHang values ('KH0004','khanhnt@gmail.com',           1, N'Nguyễn Thị Khanh',  '0366357911')
insert into khachHang values ('KH0005','nguyenvananhcm@gmail.com',    0, N'Nguyễn Văn An',     '0909393936')
insert into khachHang values ('KH0006','vanhoathobo@gmail.com',       0, N'Đinh Văn Hoạt',     '0945721460')
insert into khachHang values ('KH0007','nHuLe@gmail.com',             1, N'Lê Phan Như',       '0965351926')
insert into khachHang values ('KH0008','Linhtuan123@gmail.com',       0, N'Trần Tuấn Linh',    '0986853638')
insert into khachHang values ('KH0009','linhhoainguyen2234@gmail.com',0, N'Nguyễn Hoài Linh',  '0366547796')
insert into khachHang values ('KH0010','tungThanh898@gmail.com',      0, N'Nguyễn Thanh Tùng', '0359188480')
insert into khachHang values ('KH0011','THUHAAA@gmail.com',           1, N'Phạm Thu Hà',       '0909393939')
insert into khachHang values ('KH0012','quanghaigoal@gmail.com',      0, N'Lê Quang Hải',      '0362625704')
insert into khachHang values ('KH0013','QuyenLeHNCG@gmail.com',       1, N'Nguyễn Lệ Quyên',   '0968731191')
insert into khachHang values ('KH0014','HienThumails@gmail.com',      1, N'Trần Thu Hiền',     '0961483232')
insert into khachHang values ('KH0015','RobertG@gmail.com',           0, N'Garcia Robert',     '0337463968')
insert into khachHang values ('KH0016','Wilsonwilsonmary@gmail.com',  1, N'Wilson Mary',       '0355811769')
insert into khachHang values ('KH0017','JamesMart99@gmail.com',       0, N'Martinez James',    '0376920965')
insert into khachHang values ('KH0018','SenaHam57@gmail.com',         1, N'Mohamed Sena',      '0384003368')
insert into khachHang values ('KH0019','JosephLopeszz@gmail.com',     0, N'Lopez Joseph',      '0342827569')
insert into khachHang values ('KH0020','Christopher1996@gmail.com',   0, N'Miller Christopher','0327759268')

--them du lieu nhan vien
insert into nhanvien values ('NV0001', N'Quản lý',   N'TP. Hồ Chí Minh', 'AnhNDmanag@gmail.com',    1, N'Nguyễn Diệp Anh',    25000000, '1999-06-10', '0924608193')
insert into nhanvien values ('NV0002', N'Nhân Viên', N'TP. Hồ Chí Minh', 'namanh@gmail.com',        0, N'Trần Nam Anh',       15000000, '1989-09-11', '0962342550')
insert into nhanvien values ('NV0003', N'Nhân Viên', N'TP. Hồ Chí Minh', 'kimdung06@gmail.com',     1, N'Nguyễn Thị Kim Dung',15000000, '1999-06-14', '0335337893')
insert into nhanvien values ('NV0004', N'Nhân Viên', N'TP. Hồ Chí Minh', 'DangPham123@gmail.com',   0, N'Phạm Hồng Đăng',     15000000, '1998-05-13', '0984476509')
insert into nhanvien values ('NV0005', N'Nhân Viên', N'TP. Hồ Chí Minh', 'TriLe1998@gmail.com',     0, N'Lê Minh Trí',        15000000, '1998-06-29', '0163533782')
insert into nhanvien values ('NV0006', N'Nhân Viên', N'TP. Hồ Chí Minh', 'QHung@gmail.com',         0, N'Đỗ Quốc Hưng',       12000000, '2000-02-16', '0327654298')
insert into nhanvien values ('NV0007', N'Nhân Viên', N'TP. Hồ Chí Minh', 'QVhn@gmail.com',          0, N'Vũ Quang Vinh',      17000000, '1988-08-28', '0924655442')
insert into nhanvien values ('NV0008', N'Nhân Viên', N'TP. Hồ Chí Minh', 'trung990626@gmail.com',   0, N'Đinh Quốc Trung',    12000000, '1999-06-26', '0961728711')
insert into nhanvien values ('NV0009', N'Nhân Viên', N'TP. Hồ Chí Minh', 'tamminhle@gmail.com',     0, N'Lê Minh Tâm',        17000000, '1989-12-08', '0969795020')
insert into nhanvien values ('NV0010', N'Nhân Viên', N'TP. Hồ Chí Minh', 'nguyenclostaff@gmail.com',0, N'Trần Lê Nguyên',     15000000, '1998-08-22', '0914529039')

--them du lieu tai khoan
insert into TaiKhoan values ('TK0001', 1, 'admin','NV0001')
insert into TaiKhoan values ('TK0002', 0, '1111','NV0002')
insert into TaiKhoan values ('TK0003', 0, '1111','NV0003')
insert into TaiKhoan values ('TK0004', 0, '1111','NV0004')
insert into TaiKhoan values ('TK0005', 0, '1111','NV0005')
insert into TaiKhoan values ('TK0006', 0, '1111','NV0006')
insert into TaiKhoan values ('TK0007', 0, '1111','NV0007')
insert into TaiKhoan values ('TK0008', 0, '1111','NV0008')
insert into TaiKhoan values ('TK0009', 0, '1111','NV0009')
insert into TaiKhoan values ('TK0010', 0, '1111','NV0010')



--them du lieu hoa don
insert into HoaDon values ('HD0001','2022-09-26','KH0002','NV0001')
insert into HoaDon values ('HD0002','2022-08-11','KH0003','NV0002')
insert into HoaDon values ('HD0003','2022-07-29','KH0004','NV0003')
insert into HoaDon values ('HD0004','2022-06-05','KH0005','NV0004')
insert into HoaDon values ('HD0005','2022-05-17','KH0002','NV0005')


--them du lieu chi tiet hoa don

insert into ChiTietHoaDon values ('HD0001','SP0001',1,18150000)
insert into ChiTietHoaDon values ('HD0001','SP0004',1,15345000)
insert into ChiTietHoaDon values ('HD0001','SP0007',1,3795000)
insert into ChiTietHoaDon values ('HD0001','SP0010',1,4174500)
insert into ChiTietHoaDon values ('HD0001','SP0013',1,5885000)

insert into ChiTietHoaDon values ('HD0002','SP0002',1,26950000)
insert into ChiTietHoaDon values ('HD0002','SP0005',1,15345000)
insert into ChiTietHoaDon values ('HD0002','SP0008',1,4345000)
insert into ChiTietHoaDon values ('HD0002','SP0011',1,4779500)
insert into ChiTietHoaDon values ('HD0002','SP0014',1,8580000)

insert into ChiTietHoaDon values ('HD0003','SP0003',1,25850000)
insert into ChiTietHoaDon values ('HD0003','SP0006',1,7683500)
insert into ChiTietHoaDon values ('HD0003','SP0009',1,3690000)
insert into ChiTietHoaDon values ('HD0003','SP0012',1,4059000)
insert into ChiTietHoaDon values ('HD0003','SP0015',1,2035000)

insert into ChiTietHoaDon values ('HD0004','SP0001',1,18150000)
insert into ChiTietHoaDon values ('HD0004','SP0005',1,15345000)
insert into ChiTietHoaDon values ('HD0004','SP0008',1,4779500)

insert into ChiTietHoaDon values ('HD0005','SP0002',1,26950000)
insert into ChiTietHoaDon values ('HD0005','SP0006',1,7683500)
insert into ChiTietHoaDon values ('HD0005','SP0010',1,4235000)
insert into ChiTietHoaDon values ('HD0005','SP0014',1,8580000)





