class User {
  constructor(id, nome, email, reputacao = 5) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.reputacao = reputacao;
  }
}

class Route {
  constructor(id, origem, destino, horario, vagas, usuarioId, tipo) {
    this.id = id;
    this.origem = origem;
    this.destino = destino;
    this.horario = horario;
    this.vagas = vagas;
    this.usuarioId = usuarioId;
    this.tipo = tipo;
  }
}

module.exports = { User, Route };
