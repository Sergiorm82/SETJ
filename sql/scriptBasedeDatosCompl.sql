USE [SETJ]
GO
/****** Object:  Table [dbo].[AreaAsignacion]    Script Date: 11/12/2024 01:30:01 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AreaAsignacion](
	[IdResolucion] [int] IDENTITY(1,1) NOT NULL,
	[TipoResolucion] [nvarchar](100) NOT NULL,
	[Descripcion] [nvarchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdResolucion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Areas]    Script Date: 11/12/2024 01:30:01 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Areas](
	[IdArea] [int] IDENTITY(1,1) NOT NULL,
	[NombreArea] [nvarchar](100) NOT NULL,
	[Descripcion] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdArea] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[NombreArea] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[AsentamientosJ]    Script Date: 11/12/2024 01:30:01 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AsentamientosJ](
	[IdAsentamiento] [int] IDENTITY(1,1) NOT NULL,
	[DATO_asentamiento] [nvarchar](50) NULL,
	[DATO_tipo_asentamiento] [nvarchar](50) NULL,
	[CODIGO_tipo_asentamiento] [int] NULL,
	[IdMunicipio] [int] NULL,
	[IdCodigoPostal] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAsentamiento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[AutoridadDeterminante]    Script Date: 11/12/2024 01:30:01 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AutoridadDeterminante](
	[IdAutoridadDeterminante] [int] IDENTITY(1,1) NOT NULL,
	[DescripcionAutoridadDeterminante] [nvarchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAutoridadDeterminante] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CiudadesJ]    Script Date: 11/12/2024 01:30:01 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CiudadesJ](
	[Id_ciudad] [int] IDENTITY(1,1) NOT NULL,
	[DATO_ciudad] [nvarchar](50) NULL,
	[CODIGO_Municipio] [int] NULL,
	[DATO_estado] [nvarchar](50) NULL,
	[CODIGO_estado] [int] NULL,
	[DATO_zona] [nvarchar](50) NULL,
	[IdMunicipio] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id_ciudad] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CodigosPostalesJ]    Script Date: 11/12/2024 01:30:01 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CodigosPostalesJ](
	[IdCodigoPostal] [int] IDENTITY(1,1) NOT NULL,
	[Dato_codigoPostal] [int] NULL,
	[CODIGO_CP] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCodigoPostal] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Coordinadora]    Script Date: 11/12/2024 01:30:01 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Coordinadora](
	[Id_coordinadora] [int] IDENTITY(1,1) NOT NULL,
	[Dato_coordinadora] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id_coordinadora] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CreditosFiscales]    Script Date: 11/12/2024 01:30:01 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CreditosFiscales](
	[IDMovimiento] [int] IDENTITY(1,1) NOT NULL,
	[NumeroControl] [int] NOT NULL,
	[RFC] [nvarchar](13) NOT NULL,
	[NumeroCredito] [nvarchar](50) NOT NULL,
	[IDUsuarioCaptura] [int] NOT NULL,
	[IdArea] [int] NOT NULL,
	[IdAutoridadDeterminante] [nvarchar](50) NULL,
	[FechaIngreso] [datetime] NULL,
	[RazonSocial] [nvarchar](255) NULL,
	[Domicilio] [nvarchar](255) NULL,
	[Colonia] [nvarchar](100) NULL,
	[CodigoPostal] [nvarchar](5) NULL,
	[Municipio] [nvarchar](100) NULL,
	[FechaRecepcion] [datetime] NULL,
	[ExpedienteProcedencia] [nvarchar](100) NULL,
	[FechaDocumentoDeterminante] [datetime] NULL,
	[ImporteDeterminado] [decimal](18, 2) NULL,
	[FechaNotificacion] [datetime] NULL,
	[FechaExigible] [datetime] NULL,
	[TipoNotificacion] [nvarchar](50) NULL,
	[TipoCredito] [nvarchar](50) NULL,
	[Estatus] [nvarchar](50) NULL,
	[FechaEstatus] [datetime] NULL,
	[ObservacionesCredito] [nvarchar](max) NULL,
	[Impresion] [bit] NULL,
	[Validacion] [bit] NULL,
	[JefeDepartamento] [nvarchar](255) NULL,
	[Asignacion] [nvarchar](255) NULL,
	[Notas] [nvarchar](max) NULL,
	[IdMunicipio] [nvarchar](50) NULL,
	[IdCoordinadora] [nvarchar](50) NULL,
	[fechaCaptura] [datetime] NULL,
	[IdUsuarioUltModificacion] [int] NULL,
	[Guardado] [bit] NULL,
	[FechaUltModificacion] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[IDMovimiento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[JaliscoM]    Script Date: 11/12/2024 01:30:01 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[JaliscoM](
	[DATO_codigo] [int] NULL,
	[DATO_asentamiento] [nvarchar](50) NULL,
	[DATO_tipo_asentamiento] [nvarchar](50) NULL,
	[DATO_municipio] [nvarchar](50) NULL,
	[DATO_estado] [nvarchar](50) NULL,
	[DATO_ciudad] [nvarchar](50) NULL,
	[CODIGO_estado] [int] NULL,
	[CODIGO_CP] [int] NULL,
	[CODIGO_tipo_asentamiento] [int] NULL,
	[CODIGO_Municipio] [int] NULL,
	[DATO_zona] [nvarchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MunicipiosJ]    Script Date: 11/12/2024 01:30:01 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MunicipiosJ](
	[IdMunicipio] [int] IDENTITY(1,1) NOT NULL,
	[DATO_municipio] [nvarchar](50) NULL,
	[CODIGO_municipio] [int] NULL,
	[IdCodigoPostal] [int] NULL,
	[Id_coordinadora] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdMunicipio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 11/12/2024 01:30:01 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Roles](
	[IdRol] [int] IDENTITY(1,1) NOT NULL,
	[NombreRol] [nvarchar](50) NOT NULL,
	[Permisos] [nvarchar](max) NOT NULL,
	[Descripcion] [nvarchar](255) NULL,
	[Nivel] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRol] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[NombreRol] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TipoCredito]    Script Date: 11/12/2024 01:30:01 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TipoCredito](
	[IdTipoCredito] [int] IDENTITY(1,1) NOT NULL,
	[Descripcion] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdTipoCredito] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TipoNotificacion]    Script Date: 11/12/2024 01:30:01 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TipoNotificacion](
	[IdTipoNotificacion] [int] IDENTITY(1,1) NOT NULL,
	[Descripcion] [nvarchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdTipoNotificacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Usuarios]    Script Date: 11/12/2024 01:30:01 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuarios](
	[UsuarioID] [int] IDENTITY(1,1) NOT NULL,
	[CodigoUsuario] [nvarchar](50) NOT NULL,
	[NombreUsuario] [nvarchar](100) NOT NULL,
	[TipoUsuario] [nvarchar](50) NOT NULL,
	[Nivel] [int] NOT NULL,
	[Email] [nvarchar](100) NOT NULL,
	[Contraseña] [nvarchar](255) NOT NULL,
	[FechaCreacion] [datetime] NULL,
	[UltimoLogin] [datetime] NULL,
	[Estado] [nvarchar](10) NULL,
	[Telefono] [nvarchar](15) NULL,
	[IdRol] [int] NULL,
	[IdArea] [int] NULL,
	[Cargo] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[UsuarioID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[CodigoUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[CreditosFiscales] ADD  DEFAULT (getdate()) FOR [FechaIngreso]
GO
ALTER TABLE [dbo].[CreditosFiscales] ADD  DEFAULT ((0)) FOR [Impresion]
GO
ALTER TABLE [dbo].[CreditosFiscales] ADD  DEFAULT ((0)) FOR [Validacion]
GO
ALTER TABLE [dbo].[Usuarios] ADD  DEFAULT (getdate()) FOR [FechaCreacion]
GO
ALTER TABLE [dbo].[Usuarios] ADD  DEFAULT ('Activo') FOR [Estado]
GO
ALTER TABLE [dbo].[AsentamientosJ]  WITH CHECK ADD FOREIGN KEY([IdCodigoPostal])
REFERENCES [dbo].[CodigosPostalesJ] ([IdCodigoPostal])
GO
ALTER TABLE [dbo].[AsentamientosJ]  WITH CHECK ADD FOREIGN KEY([IdMunicipio])
REFERENCES [dbo].[MunicipiosJ] ([IdMunicipio])
GO
ALTER TABLE [dbo].[CiudadesJ]  WITH CHECK ADD FOREIGN KEY([IdMunicipio])
REFERENCES [dbo].[MunicipiosJ] ([IdMunicipio])
GO
ALTER TABLE [dbo].[CreditosFiscales]  WITH CHECK ADD  CONSTRAINT [FK_Creditos_AreaAsignacion] FOREIGN KEY([IdArea])
REFERENCES [dbo].[AreaAsignacion] ([IdResolucion])
GO
ALTER TABLE [dbo].[CreditosFiscales] CHECK CONSTRAINT [FK_Creditos_AreaAsignacion]
GO
ALTER TABLE [dbo].[CreditosFiscales]  WITH CHECK ADD  CONSTRAINT [FK_Creditos_Usuarios] FOREIGN KEY([IDUsuarioCaptura])
REFERENCES [dbo].[Usuarios] ([UsuarioID])
GO
ALTER TABLE [dbo].[CreditosFiscales] CHECK CONSTRAINT [FK_Creditos_Usuarios]
GO
ALTER TABLE [dbo].[MunicipiosJ]  WITH CHECK ADD FOREIGN KEY([IdCodigoPostal])
REFERENCES [dbo].[CodigosPostalesJ] ([IdCodigoPostal])
GO
ALTER TABLE [dbo].[MunicipiosJ]  WITH CHECK ADD  CONSTRAINT [FK_MunicipiosJ_Coordinadora] FOREIGN KEY([Id_coordinadora])
REFERENCES [dbo].[Coordinadora] ([Id_coordinadora])
GO
ALTER TABLE [dbo].[MunicipiosJ] CHECK CONSTRAINT [FK_MunicipiosJ_Coordinadora]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Fecha en que se recibe la multa o credito en la oficilia de la DNEF - (formato fecha)' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'CreditosFiscales', @level2type=N'COLUMN',@level2name=N'FechaIngreso'
GO
