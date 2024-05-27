begin;

drop table if exists dispositivo cascade;
drop table if exists bicicleta cascade;
drop table if exists reserva cascade;
drop table if exists pessoa cascade;
drop table if exists loja cascade;
drop table if exists clientereserva cascade;

create table pessoa(
    id            serial primary key,
    telefone      int          not null,
    morada        varchar(255) not null,
    cc            int          not null unique,
    nome          varchar(100) not null,
    email         varchar(100) not null unique,
    nacionalidade varchar(6)   not null
);

create table loja(
    codigo     serial primary key,
    telefone   int          not null,
    email      varchar(100) not null unique,
    endereco   varchar(255) not null,
    localidade varchar(255) not null,
    gestor     int unique references pessoa (id)
);

create table dispositivo(
    noserie   serial primary key,
    bateria   double precision not null,
    latitude  float4           not null,
    longitude float4           not null
);

create table bicicleta(
    id           serial primary key,
    modelo       varchar(200)     not null,
    peso         double precision not null,
    marca        varchar(200)     not null,
    estado       varchar(200)     not null,
    sis_mudancas varchar(200)     not null,
    atr_disc     char             not null,
    vel_max      double precision,
    autonomia    double precision,
    gps          serial unique    not null references dispositivo (noserie)
);

create table reserva(
    numero    serial primary key,
    dtinicio  timestamp not null,
    dtfim     timestamp,
    valor     money     not null,
    bicicleta int references bicicleta (id)
);

create table clientereserva(
    reserva int references reserva (numero),
    loja    int references loja (codigo),
    cliente int references pessoa (id),
    primary key (reserva, loja, cliente)
);

commit;