create table comments (
    id uuid default gen_random_uuid(),
    ts timestamp with time zone default now(),
    host varchar(255),
    path varchar(65535),
    author varchar(255),
    content text,
    primary key (id)
);
create index if not exists host_path on comments(host, path);
