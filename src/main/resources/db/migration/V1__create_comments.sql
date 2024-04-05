create table if not exists comments (
    id uuid default gen_random_uuid(),
    ts timestamp with time zone default now() not null,
    host varchar(255) not null,
    path varchar(65535) not null,
    author varchar(255) not null,
    content text not null,
    primary key (id)
);
create index if not exists host_path on comments(host, path);
