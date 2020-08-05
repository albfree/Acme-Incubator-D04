
    alter table `administrator` 
       drop 
       foreign key FK_2a5vcjo3stlfcwadosjfq49l1;

    alter table `anonymous` 
       drop 
       foreign key FK_6lnbc6fo3om54vugoh8icg78m;

    alter table `authenticated` 
       drop 
       foreign key FK_h52w0f3wjoi68b63wv9vwon57;

    alter table `consumer` 
       drop 
       foreign key FK_6cyha9f1wpj0dpbxrrjddrqed;

    alter table `investor` 
       drop 
       foreign key FK_dcek5rr514s3rww0yy57vvnpq;

    alter table `provider` 
       drop 
       foreign key FK_b1gwnjqm6ggy9yuiqm0o4rlmd;

    drop table if exists `activity`;

    drop table if exists `administrator`;

    drop table if exists `anonymous`;

    drop table if exists `authenticated`;

    drop table if exists `challenge`;

    drop table if exists `consumer`;

    drop table if exists `customization`;

    drop table if exists `escobar_bulletin`;

    drop table if exists `guerrero_bulletin`;

    drop table if exists `horrillo_bulletin`;

    drop table if exists `inquiry`;

    drop table if exists `investor`;

    drop table if exists `lobato_bulletin`;

    drop table if exists `notice`;

    drop table if exists `overture`;

    drop table if exists `perez_bulletin`;

    drop table if exists `provider`;

    drop table if exists `technology_record`;

    drop table if exists `tool_record`;

    drop table if exists `user_account`;

    drop table if exists `hibernate_sequence`;
