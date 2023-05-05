CREATE SCHEMA public;

CREATE TABLE public.clientes (
	idcliente int4 NOT NULL,
	nombre varchar(255) NOT NULL,
	genero varchar(50) NOT NULL,
	edad int4 NOT NULL,
	identificacion varchar(50) NOT NULL,
	direccion varchar(255) NOT NULL,
	telefono varchar(50) NOT NULL,
	contrasena varchar(20) NULL,
	estado bool NULL,
	CONSTRAINT clientes_pkey PRIMARY KEY (idcliente)
);



CREATE TABLE public.cuentas (
	numerocuenta int4 NOT NULL,
	tipo varchar(20) NULL,
	saldo numeric(10, 2) NULL,
	estado bool NULL,
	cliente int4 NULL,
	CONSTRAINT cuentas_pkey PRIMARY KEY (numerocuenta)
);

ALTER TABLE public.cuentas ADD CONSTRAINT cuentas_cliente_fkey FOREIGN KEY (cliente) REFERENCES public.clientes(idcliente);



CREATE TABLE public.movimientos (
	id serial4 NOT NULL,
	numerocuenta int4 NOT NULL,
	tipomovimiento text NOT NULL,
	fecha date NULL,
	movimiento int4 NULL,
	saldodisponible int4 NULL,
	tiposolicitud varchar NULL,
	CONSTRAINT movimientos_pkey PRIMARY KEY (id)
);

ALTER TABLE public.movimientos ADD CONSTRAINT movimientos_numerocuenta_fkey FOREIGN KEY (numerocuenta) REFERENCES public.cuentas(numerocuenta);