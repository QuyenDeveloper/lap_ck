create table ck_db.nganh
(
    maNganh   varchar(255) not null
        primary key,
    tenNganh  varchar(255) not null,
    loaiNganh varchar(255) not null
)
    engine = InnoDB;

create table ck_db.sinhvien
(
    soCCCD varchar(12)  not null
        primary key,
    hoTen  varchar(255) not null,
    email  varchar(255) not null,
    soDT   varchar(255) not null,
    diaChi varchar(255) not null
)
    engine = InnoDB;

create table ck_db.congviec
(
    soCCCD          varchar(12)  not null,
    ngayVaoCongTy   date         not null,
    maNganh         varchar(255) not null,
    tenCongViec     varchar(255) not null,
    tenCongTy       varchar(255) not null,
    diaChiCongTy    varchar(255) not null,
    thoiGianLamViec varchar(255) not null,
    primary key (soCCCD, ngayVaoCongTy, maNganh),
    constraint congviec_ibfk_1
        foreign key (soCCCD) references ck_db.sinhvien (soCCCD),
    constraint congviec_ibfk_2
        foreign key (maNganh) references ck_db.nganh (maNganh)
)
    engine = InnoDB;

create index maNganh
    on ck_db.congviec (maNganh);

create table ck_db.truong
(
    maTruong  varchar(255) not null
        primary key,
    tenTruong varchar(255) not null,
    diaChi    varchar(255) not null,
    soDT      varchar(255) not null
)
    engine = InnoDB;

create table ck_db.totnghiep
(
    soCCCD   varchar(12)  not null,
    maTruong varchar(255) not null,
    maNganh  varchar(255) not null,
    heTN     varchar(255) not null,
    ngayTN   date         not null,
    loaiTN   varchar(255) not null,
    primary key (soCCCD, maTruong, maNganh),
    constraint totnghiep_ibfk_1
        foreign key (maTruong) references ck_db.truong (maTruong),
    constraint totnghiep_ibfk_2
        foreign key (maNganh) references ck_db.nganh (maNganh),
    constraint totnghiep_ibfk_3
        foreign key (soCCCD) references ck_db.sinhvien (soCCCD)
)
    engine = InnoDB;

create index maNganh
    on ck_db.totnghiep (maNganh);

create index maTruong
    on ck_db.totnghiep (maTruong);


