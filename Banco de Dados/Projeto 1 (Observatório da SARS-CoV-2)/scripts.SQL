CREATE TABLE endereco (
	id serial,
	rua varchar(200),
	numero varchar(10),
	cep varchar(10),
	bairro varchar(200),
	cidade varchar(200),
	complemento TEXT,
	primary key (id)
);

 
 create table hospital (
 	id serial,
 	nome varchar(255),
 	id_endereco int,
 	primary key (id),
 	foreign key (id_endereco) references endereco (id)
 );
 
create table medico (
	crm varchar(30),
	nome varchar(255),
	cpf varchar(14),
	primary key (crm)
);

CREATE table Paciente (
	id SERIAL,
	nome varchar(255),
	cpf varchar(14),
	data_nascimento DATE,
	id_endereco INT,
	PRIMARY KEY(id),
	FOREIGN KEY(id_endereco) REFERENCES endereco(id)
);

CREATE table Enfermeiro (
	coren varchar(15),
	nome varchar(255),
	cpf varchar(14),
	data_nascimento DATE,
	data_inicio date default CURRENT_DATE,
	data_fim DATE,
	id_endereco INT,
	PRIMARY KEY(coren),
	FOREIGN KEY(id_endereco) REFERENCES endereco(id)
);

create table sintoma (
	id serial,
	nome varchar(255),
	descricao text,
	primary key (id)
);

CREATE table Leito (
	id SERIAL,
	descricao TEXT,
	localizacao varchar(25),
	id_hospital INT,
	PRIMARY KEY(id),
	FOREIGN KEY(id_hospital) REFERENCES hospital(id)
);

create table registro_desfecho (
	id serial,
	situacao varchar(255),
	crm_medico varchar(30),
	primary key (id),
	foreign key (crm_medico) references medico(crm)
);

CREATE table Ficha_Clinica (
	id SERIAL,
	massa decimal,
	altura decimal,
	oxigenacao_sangue INT,
	id_paciente INT,
	id_registro_desfecho INT,
	id_leito INT,
	PRIMARY KEY(id),
	FOREIGN KEY(id_paciente) REFERENCES paciente(id),
	FOREIGN KEY(id_registro_desfecho) REFERENCES registro_desfecho(id),
	FOREIGN KEY(id_leito) REFERENCES leito(id)
);

create table hospital_cadastra_medico (
	id_hospital int,
	crm_medico varchar(30),
	primary key (id_hospital, crm_medico),
	foreign key (id_hospital) references hospital(id),
	foreign key (crm_medico) references medico(crm)
);

create table hospital_atende_paciente (
	id_hospital int,
	id_paciente int,
	primary key (id_hospital, id_paciente),
	foreign key (id_hospital) references hospital(id),
	foreign key (id_paciente) references paciente(id)
);

create table hospital_cadastra_enfermeiro (
	id_hospital int,
	coren_enfermeiro varchar(15),
	primary key (id_hospital, coren_enfermeiro),
	foreign key (id_hospital) references hospital(id),
	foreign key (coren_enfermeiro) references enfermeiro(coren)
);

CREATE table Ficha_clinica_tem_sintoma (
	id_sintoma INT,
	id_ficha_clinica INT,
	data_sintoma DATE,
	PRIMARY KEY(id_sintoma, id_ficha_clinica),
	FOREIGN KEY(id_sintoma) REFERENCES sintoma(id),
	FOREIGN KEY(id_ficha_clinica) REFERENCES ficha_clinica(id)
);

CREATE table Enfermeiro_Difere_Ficha_Clinica  (
	id_ficha_clinica INT,
	coren_enfermeiro varchar(15),
	PRIMARY KEY(id_ficha_clinica, coren_enfermeiro),
	FOREIGN KEY(id_ficha_clinica) REFERENCES ficha_clinica(id),
	FOREIGN KEY(coren_enfermeiro) REFERENCES enfermeiro(coren)
);

create table medico_visita_paciente (
	crm_medico varchar(30),
	id_paciente int,
	data_visita date default current_date,
	primary key (crm_medico, id_paciente),
	foreign key (crm_medico) references medico(crm),
	foreign key (id_paciente) references paciente(id)
);

create table medico_prescreve_tratamento (
	crm_medico varchar(30),
	id_paciente int,
	id serial,
	nome varchar(255),
	descricao text,
	data_prescricao date default current_date,
	data_realicacao date,
	primary key (crm_medico, id_paciente, id),
	foreign key (crm_medico) references medico(crm),
	foreign key (id_paciente) references paciente(id)
);

CREATE table Medico_Prescreve_Exame (
	crm_medico varchar(30),
	id_paciente INT,
	id serial,
	nome varchar(255),
	descricao TEXT,
	data_prescricao date default current_Date,
	data_realizacao date,
	PRIMARY KEY(crm_medico, id_paciente, id),
	FOREIGN KEY(crm_medico) REFERENCES medico(crm),
	FOREIGN KEY(id_paciente) REFERENCES paciente(id)
);