const express = require('express');
const { User, Route } = require('./models');

const app = express();
app.use(express.json());

const users = [];
const routes = [];

app.post('/auth/register', (req, res) => {
  const { nome, email } = req.body;
  const user = new User(users.length + 1, nome, email);
  users.push(user);
  res.status(201).json(user);
});

app.post('/auth/login', (req, res) => {
  const { email } = req.body;
  const user = users.find(u => u.email === email);
  if (!user) return res.status(404).json({ erro: 'Usuário não encontrado' });
  res.json({ mensagem: 'Login realizado', user });
});

app.post('/rotas/motorista', (req, res) => {
  const { origem, destino, horario, vagas, usuarioId } = req.body;

  if (!origem || !destino || !horario || !vagas) {
    return res.status(400).json({ erro: 'Dados obrigatórios ausentes' });
  }

  const rota = new Route(
    routes.length + 1,
    origem,
    destino,
    horario,
    vagas,
    usuarioId,
    'motorista'
  );

  routes.push(rota);
  res.status(201).json(rota);
});

app.post('/rotas/passageiro', (req, res) => {
  const { origem, destino, horario, usuarioId } = req.body;

  const rota = new Route(
    routes.length + 1,
    origem,
    destino,
    horario,
    0,
    usuarioId,
    'passageiro'
  );

  routes.push(rota);
  res.status(201).json(rota);
});

app.get('/usuarios/:id/reputacao', (req, res) => {
  const user = users.find(u => u.id == req.params.id);

  if (!user) {
    return res.status(404).json({ erro: 'Usuário não encontrado' });
  }

  res.json({
    usuario: user.nome,
    reputacao: user.reputacao
  });
});

app.listen(3000, () =>
  console.log('Servidor executando na porta 3000')
);
