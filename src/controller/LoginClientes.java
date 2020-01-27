/*
 * @(#)LogTransformacao.java
 *
 * Copyright 2016, Senior Solution Consultoria em Informática Ltda.
 * http://www.seniorsolution.com.br
 *
 * Todos os direitos reservados.
 */
package br.com.seniorsolution.cic.model.database;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import br.com.seniorsolution.core.annotations.lock.LockId;

@Entity
@Table( name = "HistLogTrfm" )
public class HistLogTrfm implements Serializable
{
    private EntityManager em;

    public void persist(Date dtInicio, Date dtFim, char idTpArqTransformacao, long idConector,
                        long idIntegracao, int limit, int offset){
            
    }


    private static final long serialVersionUID = -180323375754732994L;

    @Id
    @Column( name = "Id" )
    private long id;

    @Column( name = "ArqTrfm" )
    private String arqTrfm;

    @Column( name = "TpArqTrfm" )
    private char tpArqTrfm;

    @Column( name = "DhIni" )
    private Timestamp dhInicio;

    @Column( name = "DhFim" )
    private Timestamp dhFim;

    @Column( name = "NvlLog" )
    private char nivelLog;

    @Column( name = "Log" )
    private String log;

    @Column( name = "IdConector" )
    private Conector conector;

    @Column( name = "IdIntg" )
    private Intg intg;

    @Column( name = "IdExecJob")
    private ExecJob execJob;

    public long getId( )
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public String getArqTransformacao( )
    {
        return this.arqTrfm;
    }

    public void setArqTransformacao( String arqTrfm )
    {
        this.arqTrfm = arqTrfm;
    }

    public TpArqTrfm getTpTransformacao( )
    {
        return TpArqTrfm.parse( this.tpArqTrfm );
    }

    public void setTpTransformacao( TpArqTrfm tpArqTrfm )
    {
        this.tpArqTrfm = tpArqTrfm.getCodigo( );
    }

    public Timestamp getDhInicio( )
    {
        return this.dhInicio;
    }

    public void setDhInicio( Timestamp dhInicio )
    {
        this.dhInicio = dhInicio;
    }

    public Timestamp getDhFim( )
    {
        return this.dhFim;
    }

    public void setDhFim( Timestamp dhFim )
    {
        this.dhFim = dhFim;
    }

    public NivelLogTransformacao getNivelLog()
    {
        return NivelLogTransformacao.parse( nivelLog );
    }

    public void setNivelLog( NivelLogTransformacao nivelLog )
    {
        this.nivelLog = nivelLog.getCode( );
    }


    public String getLog( )
    {
        return this.log;
    }

    public void setLog( String log )
    {
        this.log = log;
    }

    public Conector getConector( )
    {
        return this.conector;
    }

    public void setConector( Conector conector )
    {
        this.conector = conector;
    }

    public Intg getIntegracao()
    {
        return this.intg;
    }

    public void setIntegracao(Intg integracao)
    {
        this.intg = integracao;
    }

    public ExecJob getExecJob( )
    {
        return this.execJob;
    }

    public void setExecJob( ExecJob execJob )
    {
        this.execJob = execJob;
    }

    @Override
    public String toString( )
    {
        return ToStringBuilder.reflectionToString( this );
    }

    @Override
    public int hashCode( )
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals( Object obj )
    {
        if( this == obj )
            return true;
        if( obj == null )
            return false;
        if( getClass( ) != obj.getClass( ) )
            return false;
        LogTransformacao other = (LogTransformacao) obj;
        if( id != other.id )
            return false;
        return true;
    }

}
