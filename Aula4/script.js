let tarefas = [], filtroAtual = 'all';

const [
    tarefaForm,
    tarefaTitulo,
    tarefaDescricao,
    tarefasContainer,
    emptyState,
    themeToggle
] = [
    'tarefaForm',
    'tarefaTitulo',
    'tarefaDescricao',
    'tarefasContainer',
    'emptyState',
    'themeToggle'
].map(id => document.getElementById(id));

const botoesFiltro = document.querySelectorAll('.filter-btn');

document.addEventListener('DOMContentLoaded', () => {
    carregarTarefas();
    normalizarTarefas();
    configurarEventos();
    verificarPreferenciaTema();
    renderizarTarefas();
});

// Eventos

function configurarEventos() {
    tarefaForm.addEventListener('submit', adicionarTarefa);
    themeToggle.addEventListener('click', alternarTema);

    botoesFiltro.forEach(btn =>
        btn.addEventListener('click', e => {
            botoesFiltro.forEach(b => b.classList.remove('active'));
            e.target.classList.add('active');
            filtroAtual = e.target.dataset.filter;
            renderizarTarefas();
        })
    );
}

// Local Storage

function salvarTarefas() {
    localStorage.setItem('tarefas', JSON.stringify(tarefas));
}

function carregarTarefas() {
    tarefas = JSON.parse(localStorage.getItem('tarefas')) || [];
}

function normalizarTarefas() {
    tarefas = tarefas.map(t => ({
        _id: t._id || crypto.randomUUID(),
        titulo: t.titulo || t.name || 'Sem título',
        descricao: t.descricao || '',
        concluida: Boolean(t.concluida),
        createdAt: t.createdAt || new Date().toISOString()
    }));
    salvarTarefas();
}

// Crud

function adicionarTarefa(e) {
    e.preventDefault();

    const titulo = tarefaTitulo.value.trim();
    const descricao = tarefaDescricao.value.trim();

    if (!titulo) return alert('Informe o título da tarefa.');

    const tarefa = {
        _id: crypto.randomUUID(),
        titulo,
        descricao,
        concluida: false,
        createdAt: new Date().toISOString()
    };

    tarefas.unshift(tarefa);
    salvarTarefas();
    renderizarTarefas();
    tarefaForm.reset();
    tarefaTitulo.focus();
}

function alternarConclusaoTarefa(id) {
    tarefas = tarefas.map(t =>
        t._id === id ? { ...t, concluida: !t.concluida } : t
    );
    salvarTarefas();
    renderizarTarefas();
}

function removerTarefa(id) {
    if (!confirm('Deseja realmente excluir esta tarefa?')) return;
    tarefas = tarefas.filter(t => t._id !== id);
    salvarTarefas();
    renderizarTarefas();
}

// Renderização

function renderizarTarefas() {
    const filtros = {
        pending: t => !t.concluida,
        completed: t => t.concluida
    };

    const tarefasFiltradas = tarefas.filter(
        filtros[filtroAtual] || (() => true)
    );

    tarefasContainer.innerHTML = '';
    emptyState.style.display = tarefasFiltradas.length ? 'none' : 'block';

    if (!tarefasFiltradas.length) {
        tarefasContainer.appendChild(emptyState);
        return;
    }

    tarefasContainer.innerHTML = tarefasFiltradas.map(tarefa => {
        const data = new Date(tarefa.createdAt);
        const dataFormatada = data.toLocaleString('pt-BR');

        return `
        <div class="card tarefa-card ${tarefa.concluida ? 'tarefa-concluida' : ''}">
            <div class="card-body">

                <div class="d-flex align-items-start gap-2 mb-2 cursor-pointer"
                     onclick="alternarConclusaoTarefa('${tarefa._id}')">

                    <span class="fs-5">
                        ${
                            tarefa.concluida
                                ? '<i class="fas fa-check-circle text-success"></i>'
                                : '<i class="far fa-circle"></i>'
                        }
                    </span>

                    <h5 class="tarefa-titulo mb-0 flex-grow-1">
                        ${tarefa.titulo}
                    </h5>
                </div>

                <p class="text-muted mb-2">
                    ${tarefa.descricao || '<em>Sem descrição</em>'}
                </p>

                <div class="d-flex justify-content-between align-items-center flex-wrap gap-2">

                    <small class="text-muted">
                        📅 ${dataFormatada}
                    </small>

                    <div class="d-flex gap-2">
                        <button class="btn btn-sm ${
                            tarefa.concluida ? 'btn-success' : 'btn-primary'
                        }"
                            onclick="alternarConclusaoTarefa('${tarefa._id}')">
                            ${
                                tarefa.concluida
                                    ? '<i class="fas fa-undo"></i>'
                                    : '<i class="fas fa-check"></i>'
                            }
                        </button>

                        <button class="btn btn-sm btn-danger"
                            onclick="removerTarefa('${tarefa._id}')">
                            <i class="fas fa-trash"></i>
                        </button>
                    </div>

                </div>
            </div>
        </div>
        `;
    }).join('');
}

// Tema 

function alternarTema() {
    document.body.classList.toggle('dark-mode');
    const dark = document.body.classList.contains('dark-mode');
    localStorage.setItem('darkMode', dark);
    themeToggle.innerHTML = dark
        ? '<i class="fas fa-sun"></i>'
        : '<i class="fas fa-moon"></i>';
}

function verificarPreferenciaTema() {
    const dark = localStorage.getItem('darkMode') === 'true';
    if (dark) {
        document.body.classList.add('dark-mode');
        themeToggle.innerHTML = '<i class="fas fa-sun"></i>';
    }
}
