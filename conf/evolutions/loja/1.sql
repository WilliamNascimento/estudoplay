# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table profissional (
  id                            bigint auto_increment not null,
  nome                          varchar(255),
  profissao                     varchar(255),
  constraint pk_profissional primary key (id)
);


# --- !Downs

drop table if exists profissional;

