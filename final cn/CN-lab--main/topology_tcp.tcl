#new simulator object 
set ns [new Simulator] 
#open file 
set nf [open topology_tcp.nam w]
#store all the tracing in nf 
$ns namtrace-all $nf
set np [open topology_tcp.tr w]
#define finish procedure 
proc finish {} {
    global ns nf np
    $ns flush-trace 
    close $nf 
    close $np
    exec nam topology_tcp.nam & 
    exit 0
}
#set node 
set n0 [$ns node] 
set n1 [$ns node]  
#create a link between nodes
$ns duplex-link $n0 $n1 10Mb 10ms DropTail 
#give directions to the link 
$ns duplex-link-op $n0 $n1 orient right
#set queue size 
$ns queue-limit $n0 $n1 5 
#monitor queue 
$ns duplex-link-op $n0 $n1 queuePos 0.5 
#setup tcp connection 
set tcp [new Agent/TCP]
$ns attach-agent $n0 $tcp 
set sink [new Agent/TCPSink]
$ns attach-agent $n1 $sink 
$ns connect $tcp $sink 
$tcp set fid 1
#setup ftp over tcp connection 
set ftp [new Application/FTP]
$ftp attach-agent $tcp
#schedule event 
$ns at 0.1 "$ftp start"
$ns at 4.0 "$ftp stop"
#call the finish procedure 
$ns at 5.0 "finish"
#run the file 
$ns run
