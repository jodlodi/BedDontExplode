// noinspection ES6ConvertVarToLetConst

var ASM = Java.type('net.minecraftforge.coremod.api.ASMAPI');
var Opcodes = Java.type('org.objectweb.asm.Opcodes');

var MethodInsnNode = Java.type('org.objectweb.asm.tree.MethodInsnNode');
var VarInsnNode = Java.type('org.objectweb.asm.tree.VarInsnNode');
var InsnNode = Java.type('org.objectweb.asm.tree.InsnNode');

// noinspection JSUnusedGlobalSymbols
function initializeCoreMod() {
    return {
        'cantusebed': {
            'target': {
                'type': 'METHOD',
                'class': 'net.minecraft.world.level.block.BedBlock',
                'methodName': ASM.mapMethod('m_6227_'), // use
                'methodDesc': '(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/InteractionHand;Lnet/minecraft/world/phys/BlockHitResult;)Lnet/minecraft/world/InteractionResult;'
            },
            'transformer': function (/*org.objectweb.asm.tree.MethodNode*/ methodNode) {
                var /*org.objectweb.asm.tree.InsnList*/ instructions = methodNode.instructions;
                instructions.insertBefore(
                    ASM.findFirstMethodCall(
                        methodNode,
                        ASM.MethodType.VIRTUAL,
                        'net/minecraft/world/level/Level',
                        ASM.mapMethod('m_7471_'), // removeBlock
                        '(Lnet/minecraft/core/BlockPos;Z)Z'
                        ),
                    ASM.listOf(
                        new VarInsnNode(Opcodes.ALOAD, 4),
                        new MethodInsnNode(
                            Opcodes.INVOKESTATIC,
                            'io/github/jodlodi/bedsdontexplode/ASMHooks',
                            'cantuse',
                            '(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;ZLnet/minecraft/world/entity/player/Player;)Lnet/minecraft/world/InteractionResult;',
                            false
                            ),
                        new InsnNode(Opcodes.ARETURN)
                        )
                    );
                return methodNode;
            }
        }
    }
}
