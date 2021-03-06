/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poop;

import java.util.ArrayList;

/**
 *
 * @author JoaquimFerrer
 */
public class Interface extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    public Interface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomeField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        numeroCCField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        perfilField = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tipoField = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        perfilFuncionarioField = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        perfilProfessorField = new javax.swing.JComboBox<>();
        registarButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cursoField = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        passwordLoginField = new javax.swing.JPasswordField();
        CcLoginField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        loginSubmit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        informacaoScreen = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        logoutSubmit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        locaisList = new javax.swing.JList();
        inscreverSubmit = new javax.swing.JButton();
        verInscricoesSubmit = new javax.swing.JButton();
        getReceitasSubmit = new javax.swing.JButton();
        getGuestListSubmit = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 771, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Registar");

        jLabel2.setText("Nome");

        nomeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("NumeroCC");

        jLabel4.setText("Password");

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Perfil");

        perfilField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boemio", "Desportivo", "Cultural", "Poupadinho" }));
        perfilField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfilFieldActionPerformed(evt);
            }
        });

        jLabel6.setText("Tipo");

        tipoField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Professor", "Aluno", "Funcionario" }));
        tipoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoFieldActionPerformed(evt);
            }
        });

        jLabel7.setText("<html>Perfil<br>funcionario");

        perfilFuncionarioField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Part-Time", "Full-Time" }));

        jLabel8.setText("<html>Perfil<br>professor");

        perfilProfessorField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Auxiliar", "Catedratico", "Associado" }));

        registarButton.setText("REGISTAR");
        registarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registarButtonActionPerformed(evt);
            }
        });

        jLabel9.setText("Curso");

        cursoField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LEI", "LDM", "MDM", "MEI" }));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("Login");

        passwordLoginField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordLoginFieldActionPerformed(evt);
            }
        });

        CcLoginField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CcLoginFieldActionPerformed(evt);
            }
        });

        jLabel11.setText("Numero CC");

        jLabel12.setText("Password");

        loginSubmit.setText("Login");
        loginSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginSubmitActionPerformed(evt);
            }
        });

        informacaoScreen.setEditable(false);
        informacaoScreen.setColumns(20);
        informacaoScreen.setRows(5);
        jScrollPane1.setViewportView(informacaoScreen);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setText("Informação");

        logoutSubmit.setText("LogOut");
        logoutSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutSubmitActionPerformed(evt);
            }
        });

        locaisList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        locaisList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                locaisListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(locaisList);

        inscreverSubmit.setText("Inscrever");
        inscreverSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inscreverSubmitActionPerformed(evt);
            }
        });

        verInscricoesSubmit.setText("Ver Inscricoes");
        verInscricoesSubmit.setToolTipText("");
        verInscricoesSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verInscricoesSubmitActionPerformed(evt);
            }
        });

        getReceitasSubmit.setText("Ver Receitas");
        getReceitasSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getReceitasSubmitActionPerformed(evt);
            }
        });

        getGuestListSubmit.setText("Ver GuestList");
        getGuestListSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getGuestListSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(registarButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(perfilProfessorField, 0, 197, Short.MAX_VALUE)
                    .addComponent(cursoField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 751, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(nomeField)
                        .addComponent(numeroCCField)
                        .addComponent(passwordField)
                        .addComponent(perfilField, 0, 197, Short.MAX_VALUE)
                        .addComponent(perfilFuncionarioField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel1)))
                    .addComponent(tipoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addGap(251, 251, 251)
                        .addComponent(jLabel10)
                        .addGap(85, 85, 85))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(getReceitasSubmit)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(loginSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(logoutSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(CcLoginField, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                            .addComponent(passwordLoginField))
                                        .addGap(24, 24, 24))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(inscreverSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                            .addComponent(verInscricoesSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(getGuestListSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(tipoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(numeroCCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(perfilField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel10)))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CcLoginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(passwordLoginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(loginSubmit)
                            .addComponent(logoutSubmit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(verInscricoesSubmit)))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(perfilFuncionarioField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getReceitasSubmit))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(perfilProfessorField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(cursoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(inscreverSubmit)
                                .addGap(18, 18, 18)
                                .addComponent(getGuestListSubmit)))
                        .addGap(18, 18, 18)
                        .addComponent(registarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void perfilFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfilFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_perfilFieldActionPerformed

    private void tipoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoFieldActionPerformed

    private void registarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registarButtonActionPerformed
        // TODO add your handling code here:
    	if(!(pessoaLogada == null)) {
			informacaoScreen.setText("Faz log out primeiro!");
			return;
		}
    	
        String nome = nomeField.getText();
        String numCC = numeroCCField.getText();
        char[] password = passwordField.getPassword();
        if(nome.equals("") || numCC.equals("") || password.length == 0) {
        	informacaoScreen.setText("Preencha todos os campos prease");
        	return;

        }
        Perfil perfil = getPerfil(String.valueOf(perfilField.getSelectedItem()));
        if(String.valueOf(tipoField.getSelectedItem()).equals("Professor")) {
            if(sis.criarProfessor(getTipoProfessor(String.valueOf(perfilProfessorField.getSelectedItem())), nome, numCC, String.valueOf(password), perfil) == false) {
            	informacaoScreen.setText("user com o mesmo cc ja tinha sido criado");
            }
            else {
            	informacaoScreen.setText("Criado novo user");
        
            }
        }
        else if(String.valueOf(tipoField.getSelectedItem()).equals("Aluno")) {
            if(sis.criarEstudante(getCursoDei(String.valueOf(cursoField.getSelectedItem())), nome, numCC, String.valueOf(password), perfil) == false) {
            	informacaoScreen.setText("user com o mesmo cc ja tinha sido criado");
        	}
        	else {
        		informacaoScreen.setText("Criado novo user");
        	}
        }
        else {
            if(sis.criarFuncionario(getTipoFuncionario(String.valueOf(perfilFuncionarioField.getSelectedItem())), nome, numCC, String.valueOf(password), perfil) == false) {
            	informacaoScreen.setText("user com o mesmo cc ja tinha sido criado");
        	}
            else {
            	informacaoScreen.setText("Criado novo user");
        
            }
        }
    }//GEN-LAST:event_registarButtonActionPerformed

    private void CcLoginFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CcLoginFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CcLoginFieldActionPerformed

    private void loginSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginSubmitActionPerformed
        // TODO add your handling code here:
        String numCC = CcLoginField.getText();
        String password = String.valueOf(passwordLoginField.getPassword());
        
        if(!(pessoaLogada == null)) {
			informacaoScreen.setText("Faz logout primeiro!");
			return;
		}
       
        pessoaLogada = sis.autenticar(numCC, password);
        if(pessoaLogada == null) {
            informacaoScreen.setText("NO!");
        }
        else {
            informacaoScreen.setText("Bem vindo " + pessoaLogada.getNome());
            locaisList.setListData(sis.getLocaisOrdenados().toArray(new Local[sis.getLocaisOrdenados().size()]));
        }
    }//GEN-LAST:event_loginSubmitActionPerformed

    private void passwordLoginFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordLoginFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordLoginFieldActionPerformed

    private void logoutSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutSubmitActionPerformed
        // TODO add your handling code here:
        if(pessoaLogada != null) {
            informacaoScreen.setText("So faz falta quem cá está " + pessoaLogada.getNome());
            pessoaLogada = null;
            locaisList.setListData(new Local[0]);
        }
        else {
            informacaoScreen.setText("Quem está aí?");
        }
    }//GEN-LAST:event_logoutSubmitActionPerformed

    private void inscreverSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inscreverSubmitActionPerformed
        // TODO add your handling code here:
		if(pessoaLogada == null) {
			informacaoScreen.setText("No Login No party");
			return;
		}
		Local l = locaisList.getSelectedValue();
		if(l == null) {
			informacaoScreen.setText("Nenhum local selecionado");
			return;
		}
		if(sis.increverPessoa(pessoaLogada, l)) {
			informacaoScreen.setText("Inscrição efetuada com sucesso");
		}
		else {
			informacaoScreen.setText("Nao foi possivel inscrever. Verifica se ainda tens espaço para inscriçoes ou se não te inscreveste neste local");
		}
		
		locaisList.setListData(sis.getLocaisOrdenados().toArray(new Local[sis.getLocaisOrdenados().size()]));
    }//GEN-LAST:event_inscreverSubmitActionPerformed

    private void locaisListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_locaisListValueChanged
        // TODO add your handling code here:
		Local l = locaisList.getSelectedValue();
		if(l == null) {
			return;
		}
		String res = l.toString() + "\n" + l.getDetails() + "\n";
		res += "Inscritos: " + sis.getNInscritosLocal(l);
		informacaoScreen.setText(res);
    }//GEN-LAST:event_locaisListValueChanged

    private void verInscricoesSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verInscricoesSubmitActionPerformed
        // TODO add your handling code here:
		if(pessoaLogada == null) {
			informacaoScreen.setText("No Login No party");
			return;
		}
		ArrayList<Local> meusLocais = sis.getLocaisInscritos(pessoaLogada);
		String res = "Tens " + meusLocais.size() + " inscricoes\n";
		for(int i=0; i<meusLocais.size(); i++) {
			res += i+1 + "\n" + meusLocais.get(i).getDetails() + "\n";
		}
		informacaoScreen.setText(res);
    }//GEN-LAST:event_verInscricoesSubmitActionPerformed

    private void getReceitasSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getReceitasSubmitActionPerformed
        // TODO add your handling code here:
		if(pessoaLogada == null) {
			informacaoScreen.setText("No Login No party");
			return;
		}
		double receitas = sis.getMinReceitas();
		informacaoScreen.setText("As receitas até agora são de: " + receitas + " euros.");
    }//GEN-LAST:event_getReceitasSubmitActionPerformed

    private void getGuestListSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getGuestListSubmitActionPerformed
        // TODO add your handling code here:
		Local l = locaisList.getSelectedValue();
		if(l == null) {
			informacaoScreen.setText("nao escolheste nenhum bar");
			return;
		}
		if(!l.isBar()) {
			informacaoScreen.setText("Só existem guestLists para bares");
		}
		else {
			ArrayList<Pessoa> guestList = sis.getGuestList((Bar)l);
			String res = "";
			for(Pessoa p : guestList) {
				res += p.getGuestListFormat() + "\n";
			}
			informacaoScreen.setText(res);
		}
		if(sis.getGuestListSize((Bar)l) == 0) {
			informacaoScreen.setText("Para este bar nao ha guest list");
		}
		
    }//GEN-LAST:event_getGuestListSubmitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
		
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }
    
    private TipoProfessor getTipoProfessor(String str) {
        if(str.equals("Auxiliar")) {
            return TipoProfessor.AUXILIAR;
        }
        else if(str.equals("Catedratico")) {
            return TipoProfessor.CATEDRATICO;
        }
        else {
            return TipoProfessor.ASSOCIADO;
        }
   }
    
    private Perfil getPerfil(String str) {
        if(str.equals("Boemio")) {
            return Perfil.BOEMIO;
        }
        else if(str.equals("Cultural")) {
            return Perfil.CULTURAL;
        }
        else if(str.equals("Poupadinho")) {
            return Perfil.POUPADINHO;
        }
        else {
            return Perfil.DESPORTIVO;
        }
   }
    
    private TipoFuncionario getTipoFuncionario(String str) {
        if(str.equals("Part-Time")) {
            return TipoFuncionario.FULLTIME;
        }
        else {
            return TipoFuncionario.PARTTIME;
        }
   }
    
    private CursoDei getCursoDei(String str) {
        if(str.equals("LEI")) {
            return CursoDei.LEI;
        }
        else if(str.equals("MEI")) {
            return CursoDei.MEI;
        }
        else if(str.equals("LDM")) {
            return CursoDei.LDM;
        }
        else {
            return CursoDei.MDM;
        }
    }
    private Sistema sis = new Sistema();
    private Pessoa pessoaLogada = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CcLoginField;
    private javax.swing.JComboBox<String> cursoField;
    private javax.swing.JButton getGuestListSubmit;
    private javax.swing.JButton getReceitasSubmit;
    private javax.swing.JTextArea informacaoScreen;
    private javax.swing.JButton inscreverSubmit;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Local> locaisList;
    private javax.swing.JButton loginSubmit;
    private javax.swing.JButton logoutSubmit;
    private javax.swing.JTextField nomeField;
    private javax.swing.JTextField numeroCCField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JPasswordField passwordLoginField;
    private javax.swing.JComboBox<String> perfilField;
    private javax.swing.JComboBox<String> perfilFuncionarioField;
    private javax.swing.JComboBox<String> perfilProfessorField;
    private javax.swing.JButton registarButton;
    private javax.swing.JComboBox<String> tipoField;
    private javax.swing.JButton verInscricoesSubmit;
    // End of variables declaration//GEN-END:variables
}
